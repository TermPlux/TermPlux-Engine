import 'package:flutter_test/flutter_test.dart';
import 'package:termplux_engine/termplux_engine.dart';
import 'package:termplux_engine/termplux_engine_platform_interface.dart';
import 'package:termplux_engine/termplux_engine_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockTermpluxEnginePlatform
    with MockPlatformInterfaceMixin
    implements TermPluxEnginePlatform {
  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final TermPluxEnginePlatform initialPlatform =
      TermPluxEnginePlatform.instance;

  test('$MethodChannelTermPluxEngine is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelTermPluxEngine>());
  });

  test('getPlatformVersion', () async {
    TermPluxEngine termpluxEnginePlugin = TermPluxEngine();
    MockTermpluxEnginePlatform fakePlatform = MockTermpluxEnginePlatform();
    TermPluxEnginePlatform.instance = fakePlatform;

    expect(await termpluxEnginePlugin.getPlatformVersion(), '42');
  });
}
