@echo off
echo 本程序为网络安装,请先用引导程序(adb_wireless.apk)打开网络端口,并保证网络可达
echo 或可通过U盘安装NoodleYJ.apk,打开后即可
echo 默认adb通讯端口为5555
if "%1"=="" goto :help
platform-tools\adb connect %1 | findstr "connected"
if %errorlevel% NEQ 0 goto :help
echo 连接成功开始部署
pause
if not exist platform-tools\adb.exe goto :help
echo 即将安装文件,由于安装包较大需要刷新临时目录
echo 请确定机器已经重启过,安装出现错误信息可重试
echo 网络安装出现错误后可能需要U盘导入NoodleYJ.apk
echo 按Ctrl+C终止..
pause
platform-tools\adb root
platform-tools\adb remount
if exist bootanimation.zip platform-tools\adb push bootanimation.zip /system/media/
platform-tools\adb shell pm disable com.android.launcher3
platform-tools\adb reboot
echo 传送正常,注册成功后还需要再次重启才能使用
goto :end
:help
	echo 错误！
	echo 请输入:just_Animation+空格+远程设备地址
	pause
	goto :over
:end
	echo deploy_OK
	echo Net_deploy_OK
	pause
:over
