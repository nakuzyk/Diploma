cmd /C start/MIN java -jar selenium-server-standalone-2.46.0.jar -role hub -port 1234 -timeout 300 -browserTimeout 360

cmd /C start/MIN java -jar selenium-server-standalone-2.46.0.jar -role node -port 5599 -hub http://10.23.14.50:5558/wd/hub
-nodeConfig NodeConfig.json -Dwebdriver.chrome.driver=Drivers\chromedriver.exe
