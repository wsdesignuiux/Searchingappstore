package adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;

import java.util.List;

import e.wolfsoft1.searching_app_store.R;
import model.HomeGridModelClass;


/**
 * Created by Rp on 6/14/2016.
 */
public class RecycleAdapter_GridHome extends RecyclerView.Adapter<RecycleAdapter_GridHome.MyViewHolder> {
    Context context;


    private List<HomeGridModelClass> moviesList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        PorterShapeImageView image;
        TextView name;


        public MyViewHolder(View view) {
            super(view);

            image = (PorterShapeImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);


        }

    }


    public RecycleAdapter_GridHome(Context mainActivityContacts, List<HomeGridModelClass> moviesList) {
        this.moviesList = moviesList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_grid_list, parent, false);


        return new MyViewHolder(itemView);


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        HomeGridModelClass movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.image.setImageResource(movie.getImage());


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


}


