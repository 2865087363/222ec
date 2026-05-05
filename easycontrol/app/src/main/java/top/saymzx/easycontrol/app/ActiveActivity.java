package top.saymzx.easycontrol.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import top.saymzx.easycontrol.app.databinding.ActivityActiveBinding;
import top.saymzx.easycontrol.app.helper.ViewTools;

public class ActiveActivity extends Activity {

    private ActivityActiveBinding activityActiveBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewTools.setStatusAndNavBar(this);
        ViewTools.setLocale(this);

        try {
            activityActiveBinding = ActivityActiveBinding.inflate(getLayoutInflater());
            setContentView(activityActiveBinding.getRoot());
        } catch (Exception e) {
            setContentView(new View(this));
            return;
        }

        drawUi();
    }

    private void drawUi() {
        try {
            if (activityActiveBinding == null) return;

            activityActiveBinding.key.setText("");

            activityActiveBinding.url.setOnClickListener(v ->
                    android.content.Intent intent = new android.content.Intent(android.content.Intent.ACTION_VIEW);
                    intent.setData(android.net.Uri.parse(
                            "https://gitee.com/mingzhixianweb/easycontrol/blob/master/DONATE.md"
                    ));
                    startActivity(intent);
            );
        } catch (Exception ignored) {}
    }
}
