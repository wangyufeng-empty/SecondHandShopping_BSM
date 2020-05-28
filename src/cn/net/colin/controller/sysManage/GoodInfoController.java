package cn.net.colin.controller.sysManage;

import cn.net.colin.entity.exception.ApiResult;
import cn.net.colin.entity.exception.ResultCode;
import cn.net.colin.entity.sysManage.*;
import cn.net.colin.service.sysManage.GoodsInfoService;
import cn.net.colin.service.sysManage.GoodsPictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goodsInfo")
public class GoodInfoController {
	private static final Logger logger= LogManager.getLogger(GoodInfoController.class);

	@Autowired
	private GoodsInfoService goodsInfoService;
    @Autowired
	private GoodsPictureService goodsPictureService;

	@GetMapping("/goodsInfoList")
	public String goodsInfoList(){
		return "sysManage/goodsInfo/goodsInfoList";
	}

    /**
     * 返回用户信息列表
     * @param paramMap
     *      queryStr 搜索内容（按商品名称、发布人、商品类别、商品描述模糊查询）
     *      homepageShow 主页显示（1 是，0 否）
     * @return ResultInfo 自定义结果返回实体类
     * @throws IOException
     */
    @GetMapping("/goodsInfoDataList")
    @ResponseBody
    public ApiResult goodsList(@RequestParam Map<String,Object> paramMap) throws IOException {
        int pageNum = paramMap.get("page") == null ? 1 : Integer.parseInt(paramMap.get("page").toString());
        int pageSize = paramMap.get("limit") == null ? 10 : Integer.parseInt(paramMap.get("limit").toString());
        List<String> homeShowGoodsList = new ArrayList<String>();
        String homepageShow = "";
        if(paramMap.get("homepageShow") != null && !paramMap.get("homepageShow").toString().trim().equals("")){
            homepageShow = paramMap.get("homepageShow").toString().trim();
            GoodsPictureCriteria goodsPictureCriteria = new GoodsPictureCriteria();
            GoodsPictureCriteria.Criteria picCriteria = goodsPictureCriteria.createCriteria();
            picCriteria.andHomepageShowEqualTo(1);//查询出在主页显示的商品
            List<GoodsPicture> goodsPictureList = goodsPictureService.selectByExample(goodsPictureCriteria);
            if(goodsPictureList != null && goodsPictureList.size() > 0){
                for (GoodsPicture goodsPicture : goodsPictureList) {
                    homeShowGoodsList.add(goodsPicture.getGoodsId());
                }
            }else{
                if(homepageShow.equals("1")){//如果是查询在主页展示的商品，可以直接返回空数据
                    return ApiResult.ofDataAndTotal(ResultCode.SUCCESS,homeShowGoodsList,0);
                }
            }
        }
        GoodsInfoCriteria goodsInfoCriteria = new GoodsInfoCriteria();
        goodsInfoCriteria.setOrderByClause("goods_issuDate desc");
        if(paramMap.get("queryStr") != null && !paramMap.get("queryStr").toString().trim().equals("")){
            String likeStr = "%" + paramMap.get("queryStr").toString().trim() + "%";
            GoodsInfoCriteria.Criteria criteria1 = goodsInfoCriteria.createCriteria();
            criteria1.andGoodsNameLike(likeStr);
            if(homeShowGoodsList != null && homeShowGoodsList.size() > 0){
                if(homepageShow.equals("1")){//在主页显示的商品
                    criteria1.andGoodsIdIn(homeShowGoodsList);
                }else if(homepageShow.equals("0")){//不在主页显示的商品
                    criteria1.andGoodsIdNotIn(homeShowGoodsList);
                }
            }

            GoodsInfoCriteria.Criteria criteria2 = goodsInfoCriteria.createCriteria();
            criteria2.andGoodsPublisherLike(likeStr);
            goodsInfoCriteria.or(criteria2);
            if(homeShowGoodsList != null && homeShowGoodsList.size() > 0){
                if(homepageShow.equals("1")){//在主页显示的商品
                    criteria2.andGoodsIdIn(homeShowGoodsList);
                }else if(homepageShow.equals("0")){//不在主页显示的商品
                    criteria2.andGoodsIdNotIn(homeShowGoodsList);
                }
            }

            GoodsInfoCriteria.Criteria criteria3 = goodsInfoCriteria.createCriteria();
            criteria3.andGoodsCategoryLike(likeStr);
            goodsInfoCriteria.or(criteria3);
            if(homeShowGoodsList != null && homeShowGoodsList.size() > 0){
                if(homepageShow.equals("1")){//在主页显示的商品
                    criteria3.andGoodsIdIn(homeShowGoodsList);
                }else if(homepageShow.equals("0")){//不在主页显示的商品
                    criteria3.andGoodsIdNotIn(homeShowGoodsList);
                }
            }

            GoodsInfoCriteria.Criteria criteria4 = goodsInfoCriteria.createCriteria();
            criteria4.andGoodsDescribeLike(likeStr);
            goodsInfoCriteria.or(criteria4);
            if(homeShowGoodsList != null && homeShowGoodsList.size() > 0){
                if(homepageShow.equals("1")){//在主页显示的商品
                    criteria4.andGoodsIdIn(homeShowGoodsList);
                }else if(homepageShow.equals("0")){//不在主页显示的商品
                    criteria4.andGoodsIdNotIn(homeShowGoodsList);
                }
            }
        }else{
            if(homeShowGoodsList != null && homeShowGoodsList.size() > 0){
                GoodsInfoCriteria.Criteria criteria = goodsInfoCriteria.createCriteria();
                if(homepageShow.equals("1")){//在主页显示的商品
                    criteria.andGoodsIdIn(homeShowGoodsList);
                }else if(homepageShow.equals("0")){//不在主页显示的商品
                    criteria.andGoodsIdNotIn(homeShowGoodsList);
                }
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsInfo> goodsInfoList = goodsInfoService.selectByExample(goodsInfoCriteria);
        PageInfo pageInfo = new PageInfo(goodsInfoList);
        return ApiResult.ofDataAndTotal(ResultCode.SUCCESS,goodsInfoList,pageInfo.getTotal());
    }

    /**
     * 跳转到商品详情页面
     * @return
     */
    @GetMapping("/infoDetail/{goodsId}")
    public String infoDetail(@PathVariable("goodsId") String goodsId, Map<String,Object> modelMap){
        GoodsInfo goodsInfo = goodsInfoService.selectByPrimaryKey(goodsId);
        GoodsPictureCriteria goodsPictureCriteria = new GoodsPictureCriteria();
        goodsPictureCriteria.setOrderByClause("homePage_show desc");//为了让在首页展示的图片在第一张
        GoodsPictureCriteria.Criteria criteria = goodsPictureCriteria.createCriteria();
        criteria.andGoodsIdEqualTo(goodsInfo.getGoodsId());
        List<GoodsPicture> goodsPictures = goodsPictureService.selectByExample(goodsPictureCriteria);
        if(goodsPictures != null && goodsPictures.size() > 0){
            goodsInfo.setGoodsPictures(goodsPictures);
        }
        modelMap.put("goodsInfo",goodsInfo);
        return "sysManage/goodsInfo/goodsInfoDetail";
    }

    /**
     * 设置主页轮播图
     * @param goodsId 商品id
     * @param homepageShow 是否主页显示
     * @param goodsPictureId 商品图片id
     * @return
     */
    @PostMapping("/homePageChange")
    @ResponseBody
    public ApiResult saveUser(String goodsId,Integer homepageShow,Integer goodsPictureId){
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(goodsId != null && !goodsId.trim().equals("")){
            if(homepageShow == 0){//标识，当前图片未在主页展示，现在要设置其在主页展示
                GoodsPictureCriteria goodsPictureCriteria = new GoodsPictureCriteria();
                GoodsPictureCriteria.Criteria criteria = goodsPictureCriteria.createCriteria();
                criteria.andGoodsIdEqualTo(goodsId);
                criteria.andHomepageShowEqualTo(1);
                GoodsPicture goodsPicture = new GoodsPicture();
                goodsPicture.setHomepageShow(0);
                goodsPictureService.updateByExampleSelective(goodsPicture,goodsPictureCriteria);

                GoodsPicture targetGoodsPicture = new GoodsPicture();
                targetGoodsPicture.setIdAuto(goodsPictureId);
                targetGoodsPicture.setHomepageShow(1);
                int num = goodsPictureService.updateByPrimaryKeySelective(targetGoodsPicture);
                if(num > 0){
                    resultInfo = ApiResult.of(ResultCode.SUCCESS);
                }
            }else{//当前图片从主页移除
                GoodsPicture targetGoodsPicture = new GoodsPicture();
                targetGoodsPicture.setIdAuto(goodsPictureId);
                targetGoodsPicture.setHomepageShow(0);
                int num = goodsPictureService.updateByPrimaryKeySelective(targetGoodsPicture);
                if(num > 0){
                    resultInfo = ApiResult.of(ResultCode.SUCCESS);
                }
            }
        }
        return resultInfo;
    }

    /**
     * 根据id集合，删除用户
     * @return
     */
    @DeleteMapping("/goods/{goodsInfoIds}")
    @ResponseBody
    public ApiResult deleteUser(@PathVariable("goodsInfoIds") String [] goodsInfoIds){
        GoodsInfoCriteria goodsInfoCriteria = new GoodsInfoCriteria();
        GoodsInfoCriteria.Criteria criteria = goodsInfoCriteria.createCriteria();
        criteria.andGoodsIdIn(Arrays.asList(goodsInfoIds));
        int num = goodsInfoService.deleteByExample(goodsInfoCriteria);
        ApiResult resultInfo = ApiResult.of(ResultCode.UNKNOWN_ERROR);
        if(num > 0){
            resultInfo = ApiResult.of(ResultCode.SUCCESS);
        }
        return resultInfo;
    }
}
