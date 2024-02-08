import 'termplux_engine_platform_interface.dart';

class TermPluxEngine {
  Future<String?> getPlatformVersion() {
    return TermPluxEnginePlatform.instance.getPlatformVersion();
  }
}
