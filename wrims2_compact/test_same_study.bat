set wrims2=%~dp0\runConfig.bat

set study="%~dp0\example\CL"

cd %study% 

start /wait %wrims2%  %study%\cbc.config

start /wait %wrims2%  %study%\tolerance.config

start /wait %wrims2%  %study%\cbcdebug_cbc.config

start /wait %wrims2%  %study%\cbcdebug_xa.config


