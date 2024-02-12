import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'termplux_engine_platform_interface.dart';

class MethodChannelTermPluxEngine extends TermPluxEnginePlatform {
  @visibleForTesting
  final methodChannel = const MethodChannel('termplux_engine');

  @override
  Future<String?> getPlatformVersion() async {
    final version =
        await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
