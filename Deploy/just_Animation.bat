@echo off
echo ������Ϊ���簲װ,��������������(adb_wireless.apk)������˿�,����֤����ɴ�
echo ���ͨ��U�̰�װNoodleYJ.apk,�򿪺󼴿�
echo Ĭ��adbͨѶ�˿�Ϊ5555
if "%1"=="" goto :help
platform-tools\adb connect %1 | findstr "connected"
if %errorlevel% NEQ 0 goto :help
echo ���ӳɹ���ʼ����
pause
if not exist platform-tools\adb.exe goto :help
echo ������װ�ļ�,���ڰ�װ���ϴ���Ҫˢ����ʱĿ¼
echo ��ȷ�������Ѿ�������,��װ���ִ�����Ϣ������
echo ���簲װ���ִ���������ҪU�̵���NoodleYJ.apk
echo ��Ctrl+C��ֹ..
pause
platform-tools\adb root
platform-tools\adb remount
if exist bootanimation.zip platform-tools\adb push bootanimation.zip /system/media/
platform-tools\adb shell pm disable com.android.launcher3
platform-tools\adb reboot
echo ��������,ע��ɹ�����Ҫ�ٴ���������ʹ��
goto :end
:help
	echo ����
	echo ������:just_Animation+�ո�+Զ���豸��ַ
	pause
	goto :over
:end
	echo deploy_OK
	echo Net_deploy_OK
	pause
:over
