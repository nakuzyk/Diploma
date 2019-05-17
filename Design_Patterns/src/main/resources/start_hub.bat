set FIREFOX_DRIVER=geckodriver.exe
set CHROME_DRIVER=chromedriver.exe
set SELENIUM_SERVER_STANDALONE=selenium-server-standalone-3.141.59.jar

cmd /C start/MIN java -jar %SELENIUM_SERVER_STANDALONE% -role hub -port 1234
cmd /C start/MIN java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -jar %SELENIUM_SERVER_STANDALONE% -role node -hub http://localhost:4445/grid/register -port 5551 -browser browserName=chrome
cmd /C start/MIN java -Dwebdriver.firefox.marionette=%FIREFOX_DRIVER% -Dwebdriver.gecko.driver=%FIREFOX_DRIVER% -jar %SELENIUM_SERVER_STANDALONE% -role node -hub http://localhost:1234/grid/register -port 5558 -browser browserName=firefox
