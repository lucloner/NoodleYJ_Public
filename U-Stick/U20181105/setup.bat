@echo off
echo ������Ϊ��װ���,֤����ɴ��USB����ģʽ�Ѿ����
echo Ĭ��adbͨѶ�˿�Ϊ5555
if "%1"=="" goto :help
if not exist platform-tools\adb.exe goto :help_adb
platform-tools\adb kill-server
if "%1"=="USB" goto :usb
platform-tools\adb connect %1 | findstr "connected"
if %errorlevel% NEQ 0 goto :help
echo ���ӳɹ���ʼ����
:usb
	echo ������װ�ļ�,���ڰ�װ���ϴ���Ҫˢ����ʱĿ¼
	echo ��ȷ�������Ѿ�������,��װ���ִ�����Ϣ������
	echo ���簲װ���ִ���������ҪU�̵���NoodleYJ.apk
	echo ����apk��װʧ���������豸������
	echo ��Ctrl+C��ֹ..
	pause
	platform-tools\adb root
	platform-tools\adb remount
	echo ��װ�� %1
	if not exist bootanimation.zip goto :step2
	platform-tools\adb push bootanimation.zip /system/media/
	echo ����logo:bootanimation.zip  ... ok
:step2
	if "%2"=="" goto :finish
	if "%2"=="NOAPK" goto :step3
	if not exist %2 goto :help
	platform-tools\adb shell rm /sdcard/NoodleYJ.apk
	platform-tools\adb push %2 /sdcard/NoodleYJ.apk
	platform-tools\adb shell pm install -t -r /sdcard/NoodleYJ.apk | findstr "Success"
	if %errorlevel% NEQ 0 goto :step2_err
	echo ������NoodleYJ.apk�ļ�:%2  ... ok
	goto :step3
:step2_err
	echo ������NoodleYJ.apk�ļ�:%2  ... ʧ��,������
:step3
	if "%3"=="" goto :finish
	if not exist %3 goto :help
	platform-tools\adb push %3 /sdcard/License.zip
	echo ������ȨLicense.zip�ļ�:%3  ... ok
:finish
	echo ���ڽ�����ɽ׶�,������/��������,��Ctrl+C��ֹ..(������Ҫ�ֶ�����)
	pause
	platform-tools\adb shell pm disable com.android.launcher3
	platform-tools\adb reboot
	echo �������
	goto :end
:help_adb
	echo adbδ�ҵ���
:help
	echo ����
	echo ������:setup+�ո�+Զ���豸��ַ��USB+�ո�+NoodleYJ��װ��.apk��NOAPK+ע���ļ�License.zip
	echo ����:setup 192.168.1.50
	echo ����:setup 192.168.1.50 NoodleYJ.apk License.zip
	echo ����:setup USB NOAPK License.zip USB����,������װ,��ע��
	goto :over
:end
	echo �����������Ҫ����ע�������豸���������кŲ�ѡ�����߼���,(�������Ҫ����)
	echo OK��
:over
	echo ��������˳�...
	pause > nul
