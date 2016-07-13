package li.zhuoyuan.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 卓原 on 2016/7/13.
 */

public class TwoFragment extends Fragment {
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfragment_layout, null);
        tv = (TextView) view.findViewById(R.id.tv);
        tv.setText("这是2222222222");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TwoFragment.this.getActivity(), "2", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
