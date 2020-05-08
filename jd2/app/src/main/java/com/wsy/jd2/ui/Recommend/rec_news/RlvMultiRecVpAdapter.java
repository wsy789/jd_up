package com.wsy.jd2.ui.Recommend.rec_news;

import android.content.Context;
import android.net.Uri;
import android.nfc.tech.NfcB;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseRlvAdapter;
import com.wsy.jd2.bean.NewsBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;

public class RlvMultiRecVpAdapter extends
        BaseMultiItemQuickAdapter<NewsBean.GoodsListItemBean, BaseViewHolder> {

    private String theme;
    private NewsBean.DataBean.ArticleListBean articleListBean;
    private int view_type;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RlvMultiRecVpAdapter(List<NewsBean.GoodsListItemBean> data) {
        super(data);
        //绑定 layout 对应的 type
        addItemType(NewsBean.GoodsListItemBean.TYPE_Banner, R.layout.list_banner);
        addItemType(NewsBean.GoodsListItemBean.TYPE_Scroll, R.layout.list_scroll);
        addItemType(NewsBean.GoodsListItemBean.TYPE_Lite, R.layout.list_content);
        addItemType(NewsBean.GoodsListItemBean.TYPE_BigPicture, R.layout.list_bigpicture);
        addItemType(NewsBean.GoodsListItemBean.TYPE_BigVideo, R.layout.list_bigvideo);
      /*  List<NewsBean.DataBean.ArticleListBean> article_list = dataBean.getArticle_list();
        for (int i = 0; i < article_list.size(); i++) {
            view_type = article_list.get(i).getView_type();
        }*/
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        /*    //'view_type': '视图类型：1左图，2中间⼤图，3右图，4视频，5即时'

         *//*   NewsBean.GoodsListItemBean bigPictureContent = new NewsBean.GoodsListItemBean();
        bigPictureContent.getItemType()
        articleListBean = new NewsBean.DataBean.ArticleListBean;*//*
        if (view_type==1){
            item.itemType= NewsBean.GoodsListItemBean.TYPE_Lite;
            initRecommendList(viewHolder,item);
        }else if (view_type==2){
            item.itemType= NewsBean.GoodsListItemBean.TYPE_BigPicture;
        }else if (view_type==5){
            item.itemType= NewsBean.GoodsListItemBean.TYPE_Scroll;
            initScroll(viewHolder,item);
        }else if (viewHolder.getItemViewType()==0){
            item.itemType= NewsBean.GoodsListItemBean.TYPE_Banner;
            initBanner(viewHolder,item);
        }*/
        // 根据返回的 type 分别设置数据
        switch (viewHolder.getItemViewType()) {
            case NewsBean.GoodsListItemBean.TYPE_Banner:
                initBanner(viewHolder, item);
                break;
            case NewsBean.GoodsListItemBean.TYPE_Scroll:
                initScroll(viewHolder, item);
                break;
            case NewsBean.GoodsListItemBean.TYPE_Lite:
                initRecommendList(viewHolder, item);
                break;
            case NewsBean.GoodsListItemBean.TYPE_BigPicture:
                initRecommendList(viewHolder, item);
                break;
            case NewsBean.GoodsListItemBean.TYPE_BigVideo:
                initVideoList(viewHolder, item);
                break;
            default:
                break;
        }


    }

    private void initVideoList(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        NewsBean.DataBean.ArticleListBean bean = (NewsBean.DataBean.ArticleListBean) item.data;

  /*      viewHolder.jzvdStd.setUp(bean.getVideo_url(),
                bean.getTheme(), Jzvd.SCREEN_WINDOW_NORMAL);//参数（播放视频，文章标题，应该是样式）
   *//*     viewHolder.jzvdStd.positionInList = position;
        Glide.with(context)
                .load(bean.getImage_url())//缩略图/预览图
                .into(viewHolder.jzvdStd.posterImageView);*//*
        Glide.with(mContext)
                .load(bean.getImage_url())
                .into((ImageView) viewHolder.getView(R.id.list_video));*/
    }

    private void initScroll(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        NewsBean.DataBean bean = (NewsBean.DataBean) item.data;
        List<NewsBean.DataBean.FlashListBean> flash_list = bean.getFlash_list();
//        viewHolder.setText(R.id.recommend_scroll_tv,bean.getTheme());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < flash_list.size(); i++) {
            builder.append(flash_list.get(i).getTheme() + "       ");
//            theme = flash_list.get(i).getTheme();
        }
        viewHolder.setText(R.id.recommend_scroll_tv, builder);

    }

    private void initBanner(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        NewsBean.DataBean bean = (NewsBean.DataBean) item.data;
        List<NewsBean.DataBean.BannerListBean> banner_list = bean.getBanner_list();

//        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < banner_list.size(); i++) {
//            builder.append(banner_list.get(i).getTheme()+"       ");
            theme = banner_list.get(i).getTheme();
        }
//        viewHolder.setText(R.id.banner_recomment_tv,builder);
        viewHolder.setText(R.id.banner_recomment_tv, theme);

        Banner banner = viewHolder.getView(R.id.list_recomment_banner);
        banner.setImages(banner_list)
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        NewsBean.DataBean.BannerListBean img = (NewsBean.DataBean.BannerListBean) path;
                        Glide.with(context).load(img.getImage_url()).into(imageView);
                    }
                }).start();
    }

    private void initRecommendList(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        NewsBean.DataBean.ArticleListBean bean = (NewsBean.DataBean.ArticleListBean) item.data;
        viewHolder.setText(R.id.list_theme, bean.getTheme());
        viewHolder.setText(R.id.list_column_name, bean.getColumn_name());
//        ImageView img = viewHolder.getView(R.id.gools_item_img);
        Glide.with(mContext).load(bean.getImage_url()).into((ImageView) viewHolder.getView(R.id.list_img));

    }
}
