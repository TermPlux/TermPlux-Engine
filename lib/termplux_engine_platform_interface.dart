import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'termplux_engine_method_channel.dart';

abstract class TermPluxEnginePlatform extends PlatformInterface {
  TermPluxEnginePlatform() : super(token: _token);

  static final Object _token = Object();

  static TermPluxEnginePlatform _instance = MethodChannelTermPluxEngine();

  static TermPluxEnginePlatform get instance => _instance;

  static set instance(TermPluxEnginePlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
