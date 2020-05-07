package com.wsy.jd2.ui.Recommend.rec_news;

import android.content.Context;
import android.nfc.tech.NfcB;
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

import java.util.List;

public class RlvMultiRecVpAdapter extends
        BaseMultiItemQuickAdapter<NewsBean.GoodsListItemBean, BaseViewHolder> {

    private String theme;

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
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        // 根据返回的 type 分别设置数据
        switch (viewHolder.getItemViewType()) {
            case NewsBean.GoodsListItemBean.TYPE_Banner:
                initBanner(viewHolder,item);
                break;
            case NewsBean.GoodsListItemBean.TYPE_Scroll:
                initScroll(viewHolder,item);
                break;
            case NewsBean.GoodsListItemBean.TYPE_Lite:
                initRecommendList(viewHolder,item);
                break;
            case NewsBean.GoodsListItemBean.TYPE_BigPicture:
//                initPushContent(viewHolder,item);
                initRecommendList(viewHolder,item);
                break;
            default:
                break;
        }
    }

    private void initScroll(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        NewsBean.DataBean bean= (NewsBean.DataBean) item.data;
        List<NewsBean.DataBean.FlashListBean> flash_list = bean.getFlash_list();
//        viewHolder.setText(R.id.recommend_scroll_tv,bean.getTheme());
                StringBuilder builder = new StringBuilder();
        for (int i = 0; i < flash_list.size(); i++) {
            builder.append(flash_list.get(i).getTheme()+"       ");
//            theme = flash_list.get(i).getTheme();
        }
        viewHolder.setText(R.id.recommend_scroll_tv,builder);

    }

    private void initBanner(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        NewsBean.DataBean bean= (NewsBean.DataBean) item.data;
        List<NewsBean.DataBean.BannerListBean> banner_list = bean.getBanner_list();

//        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < banner_list.size(); i++) {
//            builder.append(banner_list.get(i).getTheme()+"       ");
            theme = banner_list.get(i).getTheme();
        }
//        viewHolder.setText(R.id.banner_recomment_tv,builder);
        viewHolder.setText(R.id.banner_recomment_tv,theme);

        Banner banner = viewHolder.getView(R.id.list_recomment_banner);
        banner.setImages(banner_list)
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        NewsBean.DataBean.BannerListBean img= (NewsBean.DataBean.BannerListBean) path;
                        Glide.with(context).load(img.getImage_url()).into(imageView);
                    }
                }).start();
    }

    private void initRecommendList(BaseViewHolder viewHolder, NewsBean.GoodsListItemBean item) {
        NewsBean.DataBean.ArticleListBean bean= (NewsBean.DataBean.ArticleListBean) item.data;
        viewHolder.setText(R.id.list_theme,bean.getTheme());
        viewHolder.setText(R.id.list_column_name,bean.getColumn_name());
//        ImageView img = viewHolder.getView(R.id.gools_item_img);
        Glide.with(mContext).load(bean.getImage_url()).into((ImageView) viewHolder.getView(R.id.list_img));

    }
}
