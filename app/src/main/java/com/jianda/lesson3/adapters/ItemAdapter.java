package com.jianda.lesson3.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jianda.lesson3.R;
import com.jianda.lesson3.utils.CircleTransform;
import com.jianda.lesson3.utils.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.jianda.lesson3.utils.Url.getIconURL;
import static com.jianda.lesson3.utils.Url.getImageURL;

/**
 * Created by Administrator on 15-12-29.
 */
public class ItemAdapter extends BaseAdapter{
    private Context context;
    private List<Item> list;

    public ItemAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        Item item = list.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();

        if(item.getUserName() != null){
            holder.nameText.setText(item.getUserName());
            Picasso.with(context)
                    .load(getIconURL(item.getUserId(), item.getUserIcon()))
                    .transform(new CircleTransform())
                    .into(holder.iconImage);
        }else {
            holder.nameText.setText("匿名用户");
            holder.iconImage.setImageResource(R.mipmap.ic_launcher);
        }
        holder.content.setText(item.getContent());
        if (item.getImage() == null) {
            holder.contentImage.setVisibility(View.GONE);
        }else {
            holder.contentImage.setVisibility(View.VISIBLE);
            Picasso.with(context)
                    .load(getImageURL(item.getImage()))
                    .resize(parent.getWidth(), 0)
//                    .fit()      //匹配
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.contentImage);

        }
        return convertView;
    }

    public void addAll(Collection<? extends Item> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    private static class ViewHolder{
        private ImageView contentImage;
        private TextView nameText;
        private TextView content;
        private ImageView iconImage;

        public ViewHolder(View itemView) {
            iconImage = (ImageView) itemView.findViewById(R.id.user_icon);
            contentImage = (ImageView) itemView.findViewById(R.id.image_content);
            content = (TextView) itemView.findViewById(R.id.content);
            nameText = (TextView) itemView.findViewById(R.id.user_name);
        }
    }
}
