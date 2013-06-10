#=====================================================================================
#  TimeStep must be monthly 
#  NumberOfSteps must be a multiple of 12
#=====================================================================================

import os
from scripts.wrims2.Study import Study
from scripts.misc import LogUtils, Param
#import shutil


# initialize
#################################
Param.mainScriptPath = __file__
LogUtils.initLogging()
#################################

# default batch file to call is 'RunStudy.bat'
s1=Study(r"studies\callite_D1641\D1641.config")
#s1.run(startYear=1921, numberOfSteps=12)
s1.run()