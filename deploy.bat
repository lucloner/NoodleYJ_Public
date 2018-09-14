@echo off
if "%1"=="" goto :help
if "%2"=="" goto :help
if not exist platform-tools\adb.exe goto :help
platform-tools\adb root
platform-tools\adb remount
platform-tools\adb install %1
platform-tools\adb push %2 /sdcard
platform-tools\adb shell pm disable com.android.launcher3
platform-tools\adb reboot
goto :end

:help
	echo 本程序需要platform-tools\adb.exe,另外需要安装adb驱动
	echo 请输入:deploy+空格+NoodleYJ安装包.apk+注册文件License.zip

:end
	echo OK��
