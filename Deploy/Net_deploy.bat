@echo off
if "%1"=="" goto :help
if "%2"=="" goto :help
if "%3"=="" goto :help
platform-tools\adb connect %1
call deploy.bat %2 %3
:help
	echo 本程序为网络安装,请先用引导程序(adb wireless)打开网络端口,并保证网络可达
	echo 或可通过U盘安装NoodleYJ.apk,打开后即可
	echo 默认adb通讯端口为5555
	echo 请输入:deploy+空格+远程设备地址+空格+NoodleYJ安装包.apk+注册文件License.zip
:end
	echo Net_deploy_OK
