package com.snow.x5web;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.snow.common.tool.utils.PermissionsUtils.REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //请求存储权限
        String[] permissions_array = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, permissions_array, REQUEST_CODE);
    }

    @OnClick({R.id.btn_01, R.id.btn_02, R.id.btn_03, R.id.btn_04, R.id.btn_05, R.id.btn_06})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_01:
                intent.setClass(this, CommonWebViewActivity.class);
                intent.putExtra("url", "http://debugtbs.qq.com");
                startActivity(intent);
                break;
            case R.id.btn_02:
                //显示000000表示加载的是系统内核，显示大于零的数字表示加载了x5内核（该数字是x5内核版本号） 
                intent.setClass(this, CommonWebViewActivity.class);
                intent.putExtra("url", "http://soft.imtt.qq.com/browser/tes/feedback.html");
                startActivity(intent);
                break;
            case R.id.btn_03:
                intent.setClass(this, CommonWebViewActivity.class);
//                intent.putExtra("url", "/storage/emulated/0/Android/data/com.zhongjian.bim/download/3#楼拆除落地脚手架方案（0817）.pdf");
//                intent.putExtra("url", "/storage/emulated/0/X5内核加载问题自查手册.pdf");
//                intent.putExtra("url", "/storage/emulated/0/tencent/MicroMsg/Download/员工考勤与休假管理制度(1).doc");
//                intent.putExtra("url", "/storage/emulated/0/tencent/MicroMsg/Download/X5内核加载问题自查手册.pdf");
//                intent.putExtra("url", "/storage/emulated/0/tencent/MicroMsg/Download/测试文档.docx");
                intent.putExtra("url", "https://vincent_zyt.gitee.io/snowzhao/categories/android/");
                startActivity(intent);
                break;
            case R.id.btn_04:
                intent.setClass(this, CommonWebViewActivity.class);//文件通过微信接收下载名称一致即可
                intent.putExtra("url", "/storage/emulated/0/tencent/MicroMsg/Download/测试文档.xlsx");
                intent.putExtra("isOpenFile", true);
                startActivity(intent);
                break;
            case R.id.btn_05:
                intent.setClass(this, CommonWebViewActivity.class);//文件通过微信接收下载名称一致即可
                intent.putExtra("url", "/storage/emulated/0/tencent/MicroMsg/Download/测试文档.pdf");
                intent.putExtra("isOpenFile", true);
                startActivity(intent);
                break;
            case R.id.btn_06:
                intent.setClass(this, CommonWebViewActivity.class);//文件通过微信接收下载名称一致即可
                intent.putExtra("url", "/storage/emulated/0/tencent/MicroMsg/Download/测试文档.doc");
                intent.putExtra("isOpenFile", true);
                startActivity(intent);
                break;
        }
    }
}
