For %%I In (*.txt) DO (
"C:\Program Files\Java\jdk1.8.0_144\bin\native2ascii" -encoding utf-8 %%I ..\ok\%%~nI.properties
)