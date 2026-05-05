package top.saymzx.easycontrol.app;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import top.saymzx.easycontrol.app.databinding.ActivityActiveBinding;
import top.saymzx.easycontrol.app.databinding.ItemLoadingBinding;
import top.saymzx.easycontrol.app.entity.AppData;
import top.saymzx.easycontrol.app.helper.ActiveHelper;
import top.saymzx.easycontrol.app.helper.PublicTools;
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
        // 如果 binding 生成失败，避免直接崩溃
        setContentView(new View(this));
    }

    // 取消激活（先保护编译）
    try {
        if (AppData.setting.getIsActive()) {
            deactivate();
        }
    } catch (Exception ignored) {}

    setButtonListener();
    drawUi();
}
private void drawUi() {
    try {
        if (activityActiveBinding == null) return;

        activityActiveBinding.key.setText(AppData.setting.getActiveKey());

        activityActiveBinding.url.setOnClickListener(v ->
                PublicTools.startUrl(
                        this,
                        "https://gitee.com/mingzhixianweb/easycontrol/blob/master/DONATE.md"
                )
        );
    } catch (Exception ignored) {}
}
