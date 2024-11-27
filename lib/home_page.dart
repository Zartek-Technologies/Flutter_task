
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  static const platform = MethodChannel('com.example.new_project/pass');

  Future<void> _getHelloWorld() async {
    try {
      final int result = await platform.invokeMethod('getHelloWorld'); // Expecting an integer
      print("Received integer from Java: $result"); // This will print the integer value, e.g., "42"
    } on PlatformException catch (e) {
      print("Failed to get message from Java: '${e.message}'.");
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text('Hello from Java')),
        body: Center(
          child: ElevatedButton(
            onPressed: _getHelloWorld,
            child: const Text('Call Java Method'),
          ),
        ),
      ),
    );
  }
}