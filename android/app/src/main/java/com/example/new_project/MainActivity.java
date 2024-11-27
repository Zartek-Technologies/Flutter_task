package com.example.new_project;

import android.os.Bundle;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.example.new_project/pass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up the method channel
        new MethodChannel(getFlutterEngine().getDartExecutor(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("getHelloWorld")) {
                                int number = getHelloWorldNumber(); // Get the integer value
                                result.success(number); // Send the integer value back to Flutter
                            } else {
                                result.notImplemented(); // Handle unimplemented methods
                            }
                        }
                );
    }

    // The Java method that returns an integer value
    private int getHelloWorldNumber() {
        return 42; // Example integer value
    }
}

