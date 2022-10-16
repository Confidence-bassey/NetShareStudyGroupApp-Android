package com.zealmobile.netsharestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class LearningResources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_resources);
    }

    public void classes(View view) {
        Intent intent = new Intent(LearningResources.this, CLASSPAGE.class);
        startActivity(intent);
    }

    public void Tutorials(View view) {
        Intent intent = new Intent(LearningResources.this, TutorialResources.class);
        startActivity(intent);
    }

    public void consultInstructors(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gomycode.online/?utm_term&utm_campaign=SEA%7CPMAX%7CNG&utm_source=adwords&utm_medium=ppc&hsa_acc=5376939631&hsa_cam=18074667495&hsa_grp&hsa_ad&hsa_src=x&hsa_tgt&hsa_kw&hsa_mt&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAjwtKmaBhBMEiwAyINuwJerrnl7APX7mDdJ0UjINtM8HPtxlIhKpVkCJNMFnoQ3MJSdT09SSRoCTC0QAvD_BwE"));
        startActivity(browserIntent);
    }

    public void LearnToCode(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gomycode.com/NG-EN/product/graphic-design"));
        startActivity(browserIntent);
    }

    public void shareResources(View view) {
        Intent intent = new Intent(LearningResources.this, TutorialResources.class);
        startActivity(intent);
    }
}