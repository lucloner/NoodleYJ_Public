@echo off
echo ������Ϊ���簲װ,��������������(adb wireless)������˿�,����֤����ɴ�
echo ���ͨ��U�̰�װNoodleYJ.apk,�򿪺󼴿�
echo Ĭ��adbͨѶ�˿�Ϊ5555
if "%1"=="" goto :help
if "%2"=="" goto :help
if "%3"=="" goto :help
platform-tools\adb connect %1 | findstr "connected"
if %errorlevel% NEQ 0 goto :help
echo ���ӳɹ���ʼ����
pause
call deploy.bat %2 %3
goto :end
:help
	echo ����
	echo ������:deploy+�ո�+Զ���豸��ַ+�ո�+NoodleYJ��װ��.apk+ע���ļ�License.zip
:end
	echo Net_deploy_OK
