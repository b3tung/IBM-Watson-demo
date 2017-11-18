package ca.uwaterloo.hackwestern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.ibm.watson.developer_cloud.android.library.camera.CameraHelper;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;
import com.squareup.picasso.Picasso;

public class Faces extends AppCompatActivity {

    private VisualRecognition vrClient;
    private CameraHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faces);
        EditText imageURLInput = findViewById(R.id.image_url);
        final String url = imageURLInput.getText().toString();

        ImageView preview = findViewById(R.id.preview);
        Picasso.with(this).load(url).into(preview);

        vrClient.detectFaces(new VisualRecognitionOptions.Builder()
                .url(url)
                .build()
        ).enqueue(new ServiceCallback<DetectedFaces>() {
            @Override
            public void onResponse(DetectedFaces response) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
