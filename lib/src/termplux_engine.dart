import 'termplux_engine_platform_interface.dart';

class TermPluxEngine implements TermPluxEnginePlatform {
  @override
  Future<String?> getPlatformVersion() {
    return TermPluxEnginePlatform.instance.getPlatformVersion();
  }
}
