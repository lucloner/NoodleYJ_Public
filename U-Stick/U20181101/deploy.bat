@echo off
if "%1"=="" goto :help
if "%2"=="" goto :help
if not exist platform-tools\adb.exe goto :help
echo ������װ�ļ�,���ڰ�װ���ϴ���Ҫˢ����ʱĿ¼
echo ��ȷ�������Ѿ�������,��װ���ִ�����Ϣ������
echo ���簲װ���ִ���������ҪU�̵���NoodleYJ.apk
echo ��Ctrl+C��ֹ..
pause
platform-tools\adb root
platform-tools\adb remount
if exist bootanimation.zip platform-tools\adb push bootanimation.zip /system/media/
platform-tools\adb install %1
platform-tools\adb push %2 /sdcard/License.zip
platform-tools\adb shell pm disable com.android.launcher3
platform-tools\adb reboot
echo ��������,ע��ɹ�����Ҫ�ٴ���������ʹ��
goto :end
:help
	echo ��������Ҫplatform-tools\adb.exe,������Ҫ��װadb����
	echo ������:deploy+�ո�+NoodleYJ��װ��.apk+ע���ļ�License.zip
	pause
	goto :over
:end
	echo deploy_OK
	pause
:over