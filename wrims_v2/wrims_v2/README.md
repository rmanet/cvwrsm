jdeps.exe -cp .\vista\lib\vista.jar lib\WRIMSv2.jar > wrimsv2.dep.txt
<br>
- WRIMSv2.jar -> java.base
- WRIMSv2.jar -> java.management
- WRIMSv2.jar -> java.sql
- WRIMSv2.jar -> java.xml
- WRIMSv2.jar -> .\vista\lib\vista.jar
- WRIMSv2.jar -> not found
<br><br>
- org.antlr.runtime                                  -> java.io                                            java.base
- org.antlr.runtime                                  -> java.lang                                          java.base
- org.antlr.runtime                                  -> java.util                                          java.base
- org.antlr.runtime                                  -> org.antlr.runtime.misc                             WRIMSv2.jar
- org.antlr.runtime                                  -> org.antlr.runtime.tree                             WRIMSv2.jar
- org.antlr.runtime.debug                            -> java.io                                            java.base
- org.antlr.runtime.debug                            -> java.lang                                          java.base
- org.antlr.runtime.debug                            -> java.net                                           java.base
- org.antlr.runtime.debug                            -> java.util                                          java.base
- org.antlr.runtime.debug                            -> org.antlr.runtime                                  WRIMSv2.jar
- org.antlr.runtime.debug                            -> org.antlr.runtime.misc                             WRIMSv2.jar
- org.antlr.runtime.debug                            -> org.antlr.runtime.tree                             WRIMSv2.jar
- org.antlr.runtime.misc                             -> java.io                                            java.base
- org.antlr.runtime.misc                             -> java.lang                                          java.base
- org.antlr.runtime.misc                             -> java.util                                          java.base
- org.antlr.runtime.tree                             -> java.io                                            java.base
- org.antlr.runtime.tree                             -> java.lang                                          java.base
- org.antlr.runtime.tree                             -> java.util                                          java.base
- org.antlr.runtime.tree                             -> java.util.regex                                    java.base
- org.antlr.runtime.tree                             -> org.antlr.runtime                                  WRIMSv2.jar
- org.antlr.runtime.tree                             -> org.antlr.runtime.misc                             WRIMSv2.jar
- org.antlr.runtime.tree                             -> org.antlr.stringtemplate                           not found
- wrimsv2.commondata.solverdata                      -> java.lang                                          java.base
- wrimsv2.commondata.solverdata                      -> java.util.concurrent                               java.base
- wrimsv2.commondata.solverdata                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.commondata.solverdata                      -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.commondata.tabledata                       -> java.lang                                          java.base
- wrimsv2.commondata.tabledata                       -> java.util                                          java.base
- wrimsv2.commondata.wresldata                       -> java.io                                            java.base
- wrimsv2.commondata.wresldata                       -> java.lang                                          java.base
- wrimsv2.commondata.wresldata                       -> java.util                                          java.base
- wrimsv2.commondata.wresldata                       -> java.util.concurrent                               java.base
- wrimsv2.commondata.wresldata                       -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.commondata.wresldata                       -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.commondata.wresldata                       -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.commondata.wresldata                       -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.commondata.wresldata                       -> wrimsv2.parallel                                   WRIMSv2.jar
- wrimsv2.components                                 -> com.sunsetsoft.xa                                  not found
- wrimsv2.components                                 -> gurobi                                             not found
- wrimsv2.components                                 -> java.io                                            java.base
- wrimsv2.components                                 -> java.lang                                          java.base
- wrimsv2.components                                 -> java.net                                           java.base
- wrimsv2.components                                 -> java.nio.file                                      java.base
- wrimsv2.components                                 -> java.text                                          java.base
- wrimsv2.components                                 -> java.time                                          java.base
- wrimsv2.components                                 -> java.time.format                                   java.base
- wrimsv2.components                                 -> java.time.temporal                                 java.base
- wrimsv2.components                                 -> java.util                                          java.base
- wrimsv2.components                                 -> java.util.concurrent                               java.base
- wrimsv2.components                                 -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.components                                 -> org.apache.commons.io                              not found
- wrimsv2.components                                 -> vista.db.dss                                       vista.jar
- wrimsv2.components                                 -> vista.set                                          vista.jar
- wrimsv2.components                                 -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.config                                     WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.debug                                      WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.external                                   WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.hdf5                                       WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.ilp                                        WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.launch                                     WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.parallel                                   WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.solver                                     WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.solver.Gurobi                              WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.solver.ortools                             WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.sql                                        WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.tools                                      WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.wreslparser.grammar                        WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.wreslplus.elements.procedures              WRIMSv2.jar
- wrimsv2.components                                 -> wrimsv2.wreslplus.grammar                          WRIMSv2.jar
- wrimsv2.config                                     -> java.io                                            java.base
- wrimsv2.config                                     -> java.lang                                          java.base
- wrimsv2.config                                     -> java.util                                          java.base
- wrimsv2.config                                     -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.config                                     -> org.apache.commons.io                              not found
- wrimsv2.config                                     -> org.coinor.cbc                                     not found
- wrimsv2.config                                     -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.config                                     -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.config                                     -> wrimsv2.ilp                                        WRIMSv2.jar
- wrimsv2.config                                     -> wrimsv2.solver                                     WRIMSv2.jar
- wrimsv2.config                                     -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.config                                     -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.config                                     -> wrimsv2.wreslplus.grammar                          WRIMSv2.jar
- wrimsv2.debug                                      -> java.io                                            java.base
- wrimsv2.debug                                      -> java.lang                                          java.base
- wrimsv2.debug                                      -> java.util                                          java.base
- wrimsv2.debug                                      -> org.apache.commons.io                              not found
- wrimsv2.debug                                      -> vista.db.dss                                       vista.jar
- wrimsv2.debug                                      -> vista.set                                          vista.jar
- wrimsv2.debug                                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.debug                                      -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.debug                                      -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.debug                                      -> wrimsv2.external                                   WRIMSv2.jar
- wrimsv2.debug                                      -> wrimsv2.solver                                     WRIMSv2.jar
- wrimsv2.debug                                      -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.evaluator                                  -> java.io                                            java.base
- wrimsv2.evaluator                                  -> java.lang                                          java.base
- wrimsv2.evaluator                                  -> java.time                                          java.base
- wrimsv2.evaluator                                  -> java.time.temporal                                 java.base
- wrimsv2.evaluator                                  -> java.util                                          java.base
- wrimsv2.evaluator                                  -> java.util.concurrent                               java.base
- wrimsv2.evaluator                                  -> java.util.regex                                    java.base
- wrimsv2.evaluator                                  -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.evaluator                                  -> org.antlr.runtime.tree                             WRIMSv2.jar
- wrimsv2.evaluator                                  -> vista.db.dss                                       vista.jar
- wrimsv2.evaluator                                  -> vista.set                                          vista.jar
- wrimsv2.evaluator                                  -> vista.time                                         vista.jar
- wrimsv2.evaluator                                  -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.external                                   WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.hdf5                                       WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.ilp                                        WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.parallel                                   WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.solver                                     WRIMSv2.jar
- wrimsv2.evaluator                                  -> wrimsv2.tools                                      WRIMSv2.jar
- wrimsv2.exception                                  -> java.lang                                          java.base
- wrimsv2.external                                   -> java.io                                            java.base
- wrimsv2.external                                   -> java.lang                                          java.base
- wrimsv2.external                                   -> java.lang.reflect                                  java.base
- wrimsv2.external                                   -> java.util                                          java.base
- wrimsv2.external                                   -> java.util.regex                                    java.base
- wrimsv2.external                                   -> jep                                                not found
- wrimsv2.external                                   -> org.tensorflow                                     not found
- wrimsv2.external                                   -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.external                                   -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.external                                   -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.external                                   -> wrimsv2.ilp                                        WRIMSv2.jar
- wrimsv2.external                                   -> wrimsv2.solver                                     WRIMSv2.jar
- wrimsv2.hdf5                                       -> java.io                                            java.base
- wrimsv2.hdf5                                       -> java.lang                                          java.base
- wrimsv2.hdf5                                       -> java.time                                          java.base
- wrimsv2.hdf5                                       -> java.time.temporal                                 java.base
- wrimsv2.hdf5                                       -> java.util                                          java.base
- wrimsv2.hdf5                                       -> ncsa.hdf.hdf5lib                                   not found
- wrimsv2.hdf5                                       -> ncsa.hdf.hdf5lib.exceptions                        not found
- wrimsv2.hdf5                                       -> vista.db.dss                                       vista.jar
- wrimsv2.hdf5                                       -> vista.set                                          vista.jar
- wrimsv2.hdf5                                       -> vista.time                                         vista.jar
- wrimsv2.hdf5                                       -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.hdf5                                       -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.hdf5                                       -> wrimsv2.config                                     WRIMSv2.jar
- wrimsv2.hdf5                                       -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.hdf5                                       -> wrimsv2.launch                                     WRIMSv2.jar
- wrimsv2.hdf5                                       -> wrimsv2.parallel                                   WRIMSv2.jar
- wrimsv2.hdf5                                       -> wrimsv2.tools                                      WRIMSv2.jar
- wrimsv2.ilp                                        -> com.google.ortools.linearsolver                    not found
- wrimsv2.ilp                                        -> com.sunsetsoft.xa                                  not found
- wrimsv2.ilp                                        -> java.io                                            java.base
- wrimsv2.ilp                                        -> java.lang                                          java.base
- wrimsv2.ilp                                        -> java.text                                          java.base
- wrimsv2.ilp                                        -> java.util                                          java.base
- wrimsv2.ilp                                        -> java.util.concurrent                               java.base
- wrimsv2.ilp                                        -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.solver                                     WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.solver.Gurobi                              WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.solver.ortools                             WRIMSv2.jar
- wrimsv2.ilp                                        -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.launch                                     -> java.io                                            java.base
- wrimsv2.launch                                     -> java.lang                                          java.base
- wrimsv2.launch                                     -> java.util                                          java.base
- wrimsv2.launch                                     -> javax.xml.parsers                                  java.xml
- wrimsv2.launch                                     -> org.w3c.dom                                        java.xml
- wrimsv2.launch                                     -> org.xml.sax                                        java.xml
- wrimsv2.launch                                     -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.launch                                     -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.launch                                     -> wrimsv2.ilp                                        WRIMSv2.jar
- wrimsv2.launch                                     -> wrimsv2.solver                                     WRIMSv2.jar
- wrimsv2.launch                                     -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.parallel                                   -> java.io                                            java.base
- wrimsv2.parallel                                   -> java.lang                                          java.base
- wrimsv2.parallel                                   -> java.util                                          java.base
- wrimsv2.parallel                                   -> java.util.concurrent                               java.base
- wrimsv2.parallel                                   -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.parallel                                   -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.parallel                                   -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.parallel                                   -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.solver                                     -> com.google.common.collect                          not found
- wrimsv2.solver                                     -> com.sunsetsoft.xa                                  not found
- wrimsv2.solver                                     -> java.io                                            java.base
- wrimsv2.solver                                     -> java.lang                                          java.base
- wrimsv2.solver                                     -> java.util                                          java.base
- wrimsv2.solver                                     -> java.util.concurrent                               java.base
- wrimsv2.solver                                     -> lpsolve                                            not found
- wrimsv2.solver                                     -> org.apache.commons.io                              not found
- wrimsv2.solver                                     -> org.coinor.cbc                                     not found
- wrimsv2.solver                                     -> org.coinor.clp                                     not found
- wrimsv2.solver                                     -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.ilp                                        WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.solver.Gurobi                              WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.solver.cbc                                 WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.solver.clp                                 WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.tools                                      WRIMSv2.jar
- wrimsv2.solver                                     -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.solver.Gurobi                              -> gurobi                                             not found
- wrimsv2.solver.Gurobi                              -> java.io                                            java.base
- wrimsv2.solver.Gurobi                              -> java.lang                                          java.base
- wrimsv2.solver.Gurobi                              -> java.util                                          java.base
- wrimsv2.solver.Gurobi                              -> java.util.concurrent                               java.base
- wrimsv2.solver.Gurobi                              -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.solver.Gurobi                              -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.solver.Gurobi                              -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.solver.Gurobi                              -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.solver.cbc                                 -> java.io                                            java.base
- wrimsv2.solver.cbc                                 -> java.lang                                          java.base
- wrimsv2.solver.cbc                                 -> java.util                                          java.base
- wrimsv2.solver.clp                                 -> java.io                                            java.base
- wrimsv2.solver.clp                                 -> java.lang                                          java.base
- wrimsv2.solver.clp                                 -> java.util                                          java.base
- wrimsv2.solver.mpmodel                             -> java.io                                            java.base
- wrimsv2.solver.mpmodel                             -> java.lang                                          java.base
- wrimsv2.solver.mpmodel                             -> java.util                                          java.base
- wrimsv2.solver.mpmodel                             -> wrimsv2.solver.mpmodel.export                      WRIMSv2.jar
- wrimsv2.solver.mpmodel                             -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.solver.mpmodel.export                      -> java.io                                            java.base
- wrimsv2.solver.mpmodel.export                      -> java.lang                                          java.base
- wrimsv2.solver.mpmodel.export                      -> java.util                                          java.base
- wrimsv2.solver.mpmodel.export                      -> java.util.concurrent                               java.base
- wrimsv2.solver.mpmodel.export                      -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.solver.mpmodel.export                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.solver.mpmodel.export                      -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.solver.mpmodel.export                      -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.solver.mpmodel.export                      -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
- wrimsv2.solver.ortools                             -> com.google.ortools.linearsolver                    not found
- wrimsv2.solver.ortools                             -> java.io                                            java.base
- wrimsv2.solver.ortools                             -> java.lang                                          java.base
- wrimsv2.solver.ortools                             -> java.util                                          java.base
- wrimsv2.solver.ortools                             -> java.util.concurrent                               java.base
- wrimsv2.solver.ortools                             -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.solver.ortools                             -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.solver.ortools                             -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.solver.ortools                             -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.solver.ortools                             -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
- wrimsv2.sql                                        -> java.io                                            java.base
- wrimsv2.sql                                        -> java.lang                                          java.base
- wrimsv2.sql                                        -> java.sql                                           java.sql
- wrimsv2.sql                                        -> java.util                                          java.base
- wrimsv2.sql                                        -> vista.db.dss                                       vista.jar
- wrimsv2.sql                                        -> vista.set                                          vista.jar
- wrimsv2.sql                                        -> vista.time                                         vista.jar
- wrimsv2.sql                                        -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.sql                                        -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.sql                                        -> wrimsv2.sql.socket                                 WRIMSv2.jar
- wrimsv2.sql                                        -> wrimsv2.tools                                      WRIMSv2.jar
- wrimsv2.sql.socket                                 -> java.io                                            java.base
- wrimsv2.sql.socket                                 -> java.lang                                          java.base
- wrimsv2.sql.socket                                 -> java.net                                           java.base
- wrimsv2.tf                                         -> java.io                                            java.base
- wrimsv2.tf                                         -> java.lang                                          java.base
- wrimsv2.tf                                         -> java.util                                          java.base
- wrimsv2.tf                                         -> org.tensorflow                                     not found
- wrimsv2.tools                                      -> de.danielbechler.diff                              not found
- wrimsv2.tools                                      -> de.danielbechler.diff.node                         not found
- wrimsv2.tools                                      -> java.io                                            java.base
- wrimsv2.tools                                      -> java.lang                                          java.base
- wrimsv2.tools                                      -> java.lang.management                               java.management
- wrimsv2.tools                                      -> java.lang.reflect                                  java.base
- wrimsv2.tools                                      -> java.security                                      java.base
- wrimsv2.tools                                      -> java.security.spec                                 java.base
- wrimsv2.tools                                      -> java.util                                          java.base
- wrimsv2.tools                                      -> java.util.concurrent                               java.base
- wrimsv2.tools                                      -> javax.crypto                                       java.base
- wrimsv2.tools                                      -> javax.crypto.spec                                  java.base
- wrimsv2.tools                                      -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.tools                                      -> sun.management                                     JDK internal API (java.management)
- wrimsv2.tools                                      -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
- wrimsv2.tools                                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.tools                                      -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.tools                                      -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.tools                                      -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.tools                                      -> wrimsv2.wreslparser.grammar                        WRIMSv2.jar
- wrimsv2.tools                                      -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.tools.solutionRangeFinder                  -> com.google.ortools.linearsolver                    not found
- wrimsv2.tools.solutionRangeFinder                  -> java.io                                            java.base
- wrimsv2.tools.solutionRangeFinder                  -> java.lang                                          java.base
- wrimsv2.tools.solutionRangeFinder                  -> java.util                                          java.base
- wrimsv2.tools.solutionRangeFinder                  -> org.apache.commons.io                              not found
- wrimsv2.tools.solutionRangeFinder                  -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
- wrimsv2.tools.solutionRangeFinder                  -> wrimsv2.solver.ortools                             WRIMSv2.jar
- wrimsv2.tools.solutionRangeFinder                  -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> com.esotericsoftware.kryo                          not found
- wrimsv2.wreslparser.elements                       -> com.esotericsoftware.kryo.io                       not found
- wrimsv2.wreslparser.elements                       -> java.io                                            java.base
- wrimsv2.wreslparser.elements                       -> java.lang                                          java.base
- wrimsv2.wreslparser.elements                       -> java.nio.charset                                   java.base
- wrimsv2.wreslparser.elements                       -> java.util                                          java.base
- wrimsv2.wreslparser.elements                       -> java.util.regex                                    java.base
- wrimsv2.wreslparser.elements                       -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> org.antlr.runtime.tree                             WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> org.apache.commons.io                              not found
- wrimsv2.wreslparser.elements                       -> org.testng                                         not found
- wrimsv2.wreslparser.elements                       -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.sql.socket                                 WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.tools                                      WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.wreslparser.grammar                        WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.wreslparser.elements                       -> wrimsv2.wreslplus.elements.procedures              WRIMSv2.jar
- wrimsv2.wreslparser.grammar                        -> java.io                                            java.base
- wrimsv2.wreslparser.grammar                        -> java.lang                                          java.base
- wrimsv2.wreslparser.grammar                        -> java.util                                          java.base
- wrimsv2.wreslparser.grammar                        -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.wreslparser.grammar                        -> org.antlr.runtime.tree                             WRIMSv2.jar
- wrimsv2.wreslparser.grammar                        -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.wreslparser.grammar                        -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.wreslparser.grammar                        -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.wreslplus.elements                         -> com.google.common.collect                          not found
- wrimsv2.wreslplus.elements                         -> java.io                                            java.base
- wrimsv2.wreslplus.elements                         -> java.lang                                          java.base
- wrimsv2.wreslplus.elements                         -> java.nio.charset                                   java.base
- wrimsv2.wreslplus.elements                         -> java.util                                          java.base
- wrimsv2.wreslplus.elements                         -> java.util.regex                                    java.base
- wrimsv2.wreslplus.elements                         -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.wreslplus.elements                         -> org.apache.commons.io                              not found
- wrimsv2.wreslplus.elements                         -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.wreslplus.elements                         -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.wreslplus.elements                         -> wrimsv2.config                                     WRIMSv2.jar
- wrimsv2.wreslplus.elements                         -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.wreslplus.elements                         -> wrimsv2.wreslplus.elements.procedures              WRIMSv2.jar
- wrimsv2.wreslplus.elements                         -> wrimsv2.wreslplus.grammar                          WRIMSv2.jar
- wrimsv2.wreslplus.elements.procedures              -> com.google.common.collect                          not found
- wrimsv2.wreslplus.elements.procedures              -> java.io                                            java.base
- wrimsv2.wreslplus.elements.procedures              -> java.lang                                          java.base
- wrimsv2.wreslplus.elements.procedures              -> java.util                                          java.base
- wrimsv2.wreslplus.elements.procedures              -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.wreslplus.elements.procedures              -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.wreslplus.elements.procedures              -> wrimsv2.components                                 WRIMSv2.jar
- wrimsv2.wreslplus.elements.procedures              -> wrimsv2.config                                     WRIMSv2.jar
- wrimsv2.wreslplus.elements.procedures              -> wrimsv2.evaluator                                  WRIMSv2.jar
- wrimsv2.wreslplus.elements.procedures              -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
- wrimsv2.wreslplus.elements.procedures              -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
- wrimsv2.wreslplus.grammar                          -> java.io                                            java.base
- wrimsv2.wreslplus.grammar                          -> java.lang                                          java.base
- wrimsv2.wreslplus.grammar                          -> java.util                                          java.base
- wrimsv2.wreslplus.grammar                          -> org.antlr.runtime                                  WRIMSv2.jar
- wrimsv2.wreslplus.grammar                          -> org.antlr.runtime.tree                             WRIMSv2.jar
- wrimsv2.wreslplus.grammar                          -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
- wrimsv2.wreslplus.grammar                          -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
<<<<<<< HEAD
- wrimsv2.wreslplus.grammar                          -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
=======
- wrimsv2.wreslplus.grammar                          -> wrimsv2.wreslplus.elements                         WRIMSv2.jar

WRIMSv2.jar -> java.base
WRIMSv2.jar -> java.management
WRIMSv2.jar -> java.sql
WRIMSv2.jar -> java.xml
WRIMSv2.jar -> .\vista\lib\vista.jar
WRIMSv2.jar -> not found

   org.antlr.runtime                                  -> java.io                                            java.base
   org.antlr.runtime                                  -> java.lang                                          java.base
   org.antlr.runtime                                  -> java.util                                          java.base
   org.antlr.runtime                                  -> org.antlr.runtime.misc                             WRIMSv2.jar
   org.antlr.runtime                                  -> org.antlr.runtime.tree                             WRIMSv2.jar
   org.antlr.runtime.debug                            -> java.io                                            java.base
   org.antlr.runtime.debug                            -> java.lang                                          java.base
   org.antlr.runtime.debug                            -> java.net                                           java.base
   org.antlr.runtime.debug                            -> java.util                                          java.base
   org.antlr.runtime.debug                            -> org.antlr.runtime                                  WRIMSv2.jar
   org.antlr.runtime.debug                            -> org.antlr.runtime.misc                             WRIMSv2.jar
   org.antlr.runtime.debug                            -> org.antlr.runtime.tree                             WRIMSv2.jar
   org.antlr.runtime.misc                             -> java.io                                            java.base
   org.antlr.runtime.misc                             -> java.lang                                          java.base
   org.antlr.runtime.misc                             -> java.util                                          java.base
   org.antlr.runtime.tree                             -> java.io                                            java.base
   org.antlr.runtime.tree                             -> java.lang                                          java.base
   org.antlr.runtime.tree                             -> java.util                                          java.base
   org.antlr.runtime.tree                             -> java.util.regex                                    java.base
   org.antlr.runtime.tree                             -> org.antlr.runtime                                  WRIMSv2.jar
   org.antlr.runtime.tree                             -> org.antlr.runtime.misc                             WRIMSv2.jar
   org.antlr.runtime.tree                             -> org.antlr.stringtemplate                           not found
   wrimsv2.commondata.solverdata                      -> java.lang                                          java.base
   wrimsv2.commondata.solverdata                      -> java.util.concurrent                               java.base
   wrimsv2.commondata.solverdata                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.commondata.solverdata                      -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.commondata.tabledata                       -> java.lang                                          java.base
   wrimsv2.commondata.tabledata                       -> java.util                                          java.base
   wrimsv2.commondata.wresldata                       -> java.io                                            java.base
   wrimsv2.commondata.wresldata                       -> java.lang                                          java.base
   wrimsv2.commondata.wresldata                       -> java.util                                          java.base
   wrimsv2.commondata.wresldata                       -> java.util.concurrent                               java.base
   wrimsv2.commondata.wresldata                       -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.commondata.wresldata                       -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.commondata.wresldata                       -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.commondata.wresldata                       -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.commondata.wresldata                       -> wrimsv2.parallel                                   WRIMSv2.jar
   wrimsv2.components                                 -> com.sunsetsoft.xa                                  not found
   wrimsv2.components                                 -> gurobi                                             not found
   wrimsv2.components                                 -> java.io                                            java.base
   wrimsv2.components                                 -> java.lang                                          java.base
   wrimsv2.components                                 -> java.net                                           java.base
   wrimsv2.components                                 -> java.nio.file                                      java.base
   wrimsv2.components                                 -> java.text                                          java.base
   wrimsv2.components                                 -> java.time                                          java.base
   wrimsv2.components                                 -> java.time.format                                   java.base
   wrimsv2.components                                 -> java.time.temporal                                 java.base
   wrimsv2.components                                 -> java.util                                          java.base
   wrimsv2.components                                 -> java.util.concurrent                               java.base
   wrimsv2.components                                 -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.components                                 -> org.apache.commons.io                              not found
   wrimsv2.components                                 -> vista.db.dss                                       vista.jar
   wrimsv2.components                                 -> vista.set                                          vista.jar
   wrimsv2.components                                 -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.config                                     WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.debug                                      WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.external                                   WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.hdf5                                       WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.ilp                                        WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.launch                                     WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.parallel                                   WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.solver                                     WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.solver.Gurobi                              WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.solver.ortools                             WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.sql                                        WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.tools                                      WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.wreslparser.grammar                        WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.wreslplus.elements.procedures              WRIMSv2.jar
   wrimsv2.components                                 -> wrimsv2.wreslplus.grammar                          WRIMSv2.jar
   wrimsv2.config                                     -> java.io                                            java.base
   wrimsv2.config                                     -> java.lang                                          java.base
   wrimsv2.config                                     -> java.util                                          java.base
   wrimsv2.config                                     -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.config                                     -> org.apache.commons.io                              not found
   wrimsv2.config                                     -> org.coinor.cbc                                     not found
   wrimsv2.config                                     -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.config                                     -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.config                                     -> wrimsv2.ilp                                        WRIMSv2.jar
   wrimsv2.config                                     -> wrimsv2.solver                                     WRIMSv2.jar
   wrimsv2.config                                     -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.config                                     -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.config                                     -> wrimsv2.wreslplus.grammar                          WRIMSv2.jar
   wrimsv2.debug                                      -> java.io                                            java.base
   wrimsv2.debug                                      -> java.lang                                          java.base
   wrimsv2.debug                                      -> java.util                                          java.base
   wrimsv2.debug                                      -> org.apache.commons.io                              not found
   wrimsv2.debug                                      -> vista.db.dss                                       vista.jar
   wrimsv2.debug                                      -> vista.set                                          vista.jar
   wrimsv2.debug                                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.debug                                      -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.debug                                      -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.debug                                      -> wrimsv2.external                                   WRIMSv2.jar
   wrimsv2.debug                                      -> wrimsv2.solver                                     WRIMSv2.jar
   wrimsv2.debug                                      -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.evaluator                                  -> java.io                                            java.base
   wrimsv2.evaluator                                  -> java.lang                                          java.base
   wrimsv2.evaluator                                  -> java.time                                          java.base
   wrimsv2.evaluator                                  -> java.time.temporal                                 java.base
   wrimsv2.evaluator                                  -> java.util                                          java.base
   wrimsv2.evaluator                                  -> java.util.concurrent                               java.base
   wrimsv2.evaluator                                  -> java.util.regex                                    java.base
   wrimsv2.evaluator                                  -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.evaluator                                  -> org.antlr.runtime.tree                             WRIMSv2.jar
   wrimsv2.evaluator                                  -> vista.db.dss                                       vista.jar
   wrimsv2.evaluator                                  -> vista.set                                          vista.jar
   wrimsv2.evaluator                                  -> vista.time                                         vista.jar
   wrimsv2.evaluator                                  -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.external                                   WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.hdf5                                       WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.ilp                                        WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.parallel                                   WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.solver                                     WRIMSv2.jar
   wrimsv2.evaluator                                  -> wrimsv2.tools                                      WRIMSv2.jar
   wrimsv2.exception                                  -> java.lang                                          java.base
   wrimsv2.external                                   -> java.io                                            java.base
   wrimsv2.external                                   -> java.lang                                          java.base
   wrimsv2.external                                   -> java.lang.reflect                                  java.base
   wrimsv2.external                                   -> java.util                                          java.base
   wrimsv2.external                                   -> java.util.regex                                    java.base
   wrimsv2.external                                   -> jep                                                not found
   wrimsv2.external                                   -> org.tensorflow                                     not found
   wrimsv2.external                                   -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.external                                   -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.external                                   -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.external                                   -> wrimsv2.ilp                                        WRIMSv2.jar
   wrimsv2.external                                   -> wrimsv2.solver                                     WRIMSv2.jar
   wrimsv2.hdf5                                       -> java.io                                            java.base
   wrimsv2.hdf5                                       -> java.lang                                          java.base
   wrimsv2.hdf5                                       -> java.time                                          java.base
   wrimsv2.hdf5                                       -> java.time.temporal                                 java.base
   wrimsv2.hdf5                                       -> java.util                                          java.base
   wrimsv2.hdf5                                       -> ncsa.hdf.hdf5lib                                   not found
   wrimsv2.hdf5                                       -> ncsa.hdf.hdf5lib.exceptions                        not found
   wrimsv2.hdf5                                       -> vista.db.dss                                       vista.jar
   wrimsv2.hdf5                                       -> vista.set                                          vista.jar
   wrimsv2.hdf5                                       -> vista.time                                         vista.jar
   wrimsv2.hdf5                                       -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.hdf5                                       -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.hdf5                                       -> wrimsv2.config                                     WRIMSv2.jar
   wrimsv2.hdf5                                       -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.hdf5                                       -> wrimsv2.launch                                     WRIMSv2.jar
   wrimsv2.hdf5                                       -> wrimsv2.parallel                                   WRIMSv2.jar
   wrimsv2.hdf5                                       -> wrimsv2.tools                                      WRIMSv2.jar
   wrimsv2.ilp                                        -> com.google.ortools.linearsolver                    not found
   wrimsv2.ilp                                        -> com.sunsetsoft.xa                                  not found
   wrimsv2.ilp                                        -> java.io                                            java.base
   wrimsv2.ilp                                        -> java.lang                                          java.base
   wrimsv2.ilp                                        -> java.text                                          java.base
   wrimsv2.ilp                                        -> java.util                                          java.base
   wrimsv2.ilp                                        -> java.util.concurrent                               java.base
   wrimsv2.ilp                                        -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.solver                                     WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.solver.Gurobi                              WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.solver.ortools                             WRIMSv2.jar
   wrimsv2.ilp                                        -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.launch                                     -> java.io                                            java.base
   wrimsv2.launch                                     -> java.lang                                          java.base
   wrimsv2.launch                                     -> java.util                                          java.base
   wrimsv2.launch                                     -> javax.xml.parsers                                  java.xml
   wrimsv2.launch                                     -> org.w3c.dom                                        java.xml
   wrimsv2.launch                                     -> org.xml.sax                                        java.xml
   wrimsv2.launch                                     -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.launch                                     -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.launch                                     -> wrimsv2.ilp                                        WRIMSv2.jar
   wrimsv2.launch                                     -> wrimsv2.solver                                     WRIMSv2.jar
   wrimsv2.launch                                     -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.parallel                                   -> java.io                                            java.base
   wrimsv2.parallel                                   -> java.lang                                          java.base
   wrimsv2.parallel                                   -> java.util                                          java.base
   wrimsv2.parallel                                   -> java.util.concurrent                               java.base
   wrimsv2.parallel                                   -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.parallel                                   -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.parallel                                   -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.parallel                                   -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.solver                                     -> com.google.common.collect                          not found
   wrimsv2.solver                                     -> com.sunsetsoft.xa                                  not found
   wrimsv2.solver                                     -> java.io                                            java.base
   wrimsv2.solver                                     -> java.lang                                          java.base
   wrimsv2.solver                                     -> java.util                                          java.base
   wrimsv2.solver                                     -> java.util.concurrent                               java.base
   wrimsv2.solver                                     -> lpsolve                                            not found
   wrimsv2.solver                                     -> org.apache.commons.io                              not found
   wrimsv2.solver                                     -> org.coinor.cbc                                     not found
   wrimsv2.solver                                     -> org.coinor.clp                                     not found
   wrimsv2.solver                                     -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.ilp                                        WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.solver.Gurobi                              WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.solver.cbc                                 WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.solver.clp                                 WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.tools                                      WRIMSv2.jar
   wrimsv2.solver                                     -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.solver.Gurobi                              -> gurobi                                             not found
   wrimsv2.solver.Gurobi                              -> java.io                                            java.base
   wrimsv2.solver.Gurobi                              -> java.lang                                          java.base
   wrimsv2.solver.Gurobi                              -> java.util                                          java.base
   wrimsv2.solver.Gurobi                              -> java.util.concurrent                               java.base
   wrimsv2.solver.Gurobi                              -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.solver.Gurobi                              -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.solver.Gurobi                              -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.solver.Gurobi                              -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.solver.cbc                                 -> java.io                                            java.base
   wrimsv2.solver.cbc                                 -> java.lang                                          java.base
   wrimsv2.solver.cbc                                 -> java.util                                          java.base
   wrimsv2.solver.clp                                 -> java.io                                            java.base
   wrimsv2.solver.clp                                 -> java.lang                                          java.base
   wrimsv2.solver.clp                                 -> java.util                                          java.base
   wrimsv2.solver.mpmodel                             -> java.io                                            java.base
   wrimsv2.solver.mpmodel                             -> java.lang                                          java.base
   wrimsv2.solver.mpmodel                             -> java.util                                          java.base
   wrimsv2.solver.mpmodel                             -> wrimsv2.solver.mpmodel.export                      WRIMSv2.jar
   wrimsv2.solver.mpmodel                             -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.solver.mpmodel.export                      -> java.io                                            java.base
   wrimsv2.solver.mpmodel.export                      -> java.lang                                          java.base
   wrimsv2.solver.mpmodel.export                      -> java.util                                          java.base
   wrimsv2.solver.mpmodel.export                      -> java.util.concurrent                               java.base
   wrimsv2.solver.mpmodel.export                      -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.solver.mpmodel.export                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.solver.mpmodel.export                      -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.solver.mpmodel.export                      -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.solver.mpmodel.export                      -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
   wrimsv2.solver.ortools                             -> com.google.ortools.linearsolver                    not found
   wrimsv2.solver.ortools                             -> java.io                                            java.base
   wrimsv2.solver.ortools                             -> java.lang                                          java.base
   wrimsv2.solver.ortools                             -> java.util                                          java.base
   wrimsv2.solver.ortools                             -> java.util.concurrent                               java.base
   wrimsv2.solver.ortools                             -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.solver.ortools                             -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.solver.ortools                             -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.solver.ortools                             -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.solver.ortools                             -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
   wrimsv2.sql                                        -> java.io                                            java.base
   wrimsv2.sql                                        -> java.lang                                          java.base
   wrimsv2.sql                                        -> java.sql                                           java.sql
   wrimsv2.sql                                        -> java.util                                          java.base
   wrimsv2.sql                                        -> vista.db.dss                                       vista.jar
   wrimsv2.sql                                        -> vista.set                                          vista.jar
   wrimsv2.sql                                        -> vista.time                                         vista.jar
   wrimsv2.sql                                        -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.sql                                        -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.sql                                        -> wrimsv2.sql.socket                                 WRIMSv2.jar
   wrimsv2.sql                                        -> wrimsv2.tools                                      WRIMSv2.jar
   wrimsv2.sql.socket                                 -> java.io                                            java.base
   wrimsv2.sql.socket                                 -> java.lang                                          java.base
   wrimsv2.sql.socket                                 -> java.net                                           java.base
   wrimsv2.tf                                         -> java.io                                            java.base
   wrimsv2.tf                                         -> java.lang                                          java.base
   wrimsv2.tf                                         -> java.util                                          java.base
   wrimsv2.tf                                         -> org.tensorflow                                     not found
   wrimsv2.tools                                      -> de.danielbechler.diff                              not found
   wrimsv2.tools                                      -> de.danielbechler.diff.node                         not found
   wrimsv2.tools                                      -> java.io                                            java.base
   wrimsv2.tools                                      -> java.lang                                          java.base
   wrimsv2.tools                                      -> java.lang.management                               java.management
   wrimsv2.tools                                      -> java.lang.reflect                                  java.base
   wrimsv2.tools                                      -> java.security                                      java.base
   wrimsv2.tools                                      -> java.security.spec                                 java.base
   wrimsv2.tools                                      -> java.util                                          java.base
   wrimsv2.tools                                      -> java.util.concurrent                               java.base
   wrimsv2.tools                                      -> javax.crypto                                       java.base
   wrimsv2.tools                                      -> javax.crypto.spec                                  java.base
   wrimsv2.tools                                      -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.tools                                      -> sun.management                                     JDK internal API (java.management)
   wrimsv2.tools                                      -> wrimsv2.commondata.solverdata                      WRIMSv2.jar
   wrimsv2.tools                                      -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.tools                                      -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.tools                                      -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.tools                                      -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.tools                                      -> wrimsv2.wreslparser.grammar                        WRIMSv2.jar
   wrimsv2.tools                                      -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.tools.solutionRangeFinder                  -> com.google.ortools.linearsolver                    not found
   wrimsv2.tools.solutionRangeFinder                  -> java.io                                            java.base
   wrimsv2.tools.solutionRangeFinder                  -> java.lang                                          java.base
   wrimsv2.tools.solutionRangeFinder                  -> java.util                                          java.base
   wrimsv2.tools.solutionRangeFinder                  -> org.apache.commons.io                              not found
   wrimsv2.tools.solutionRangeFinder                  -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
   wrimsv2.tools.solutionRangeFinder                  -> wrimsv2.solver.ortools                             WRIMSv2.jar
   wrimsv2.tools.solutionRangeFinder                  -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> com.esotericsoftware.kryo                          not found
   wrimsv2.wreslparser.elements                       -> com.esotericsoftware.kryo.io                       not found
   wrimsv2.wreslparser.elements                       -> java.io                                            java.base
   wrimsv2.wreslparser.elements                       -> java.lang                                          java.base
   wrimsv2.wreslparser.elements                       -> java.nio.charset                                   java.base
   wrimsv2.wreslparser.elements                       -> java.util                                          java.base
   wrimsv2.wreslparser.elements                       -> java.util.regex                                    java.base
   wrimsv2.wreslparser.elements                       -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> org.antlr.runtime.tree                             WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> org.apache.commons.io                              not found
   wrimsv2.wreslparser.elements                       -> org.testng                                         not found
   wrimsv2.wreslparser.elements                       -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.solver.mpmodel                             WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.sql.socket                                 WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.tools                                      WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.wreslparser.grammar                        WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.wreslparser.elements                       -> wrimsv2.wreslplus.elements.procedures              WRIMSv2.jar
   wrimsv2.wreslparser.grammar                        -> java.io                                            java.base
   wrimsv2.wreslparser.grammar                        -> java.lang                                          java.base
   wrimsv2.wreslparser.grammar                        -> java.util                                          java.base
   wrimsv2.wreslparser.grammar                        -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.wreslparser.grammar                        -> org.antlr.runtime.tree                             WRIMSv2.jar
   wrimsv2.wreslparser.grammar                        -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.wreslparser.grammar                        -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.wreslparser.grammar                        -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.wreslplus.elements                         -> com.google.common.collect                          not found
   wrimsv2.wreslplus.elements                         -> java.io                                            java.base
   wrimsv2.wreslplus.elements                         -> java.lang                                          java.base
   wrimsv2.wreslplus.elements                         -> java.nio.charset                                   java.base
   wrimsv2.wreslplus.elements                         -> java.util                                          java.base
   wrimsv2.wreslplus.elements                         -> java.util.regex                                    java.base
   wrimsv2.wreslplus.elements                         -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.wreslplus.elements                         -> org.apache.commons.io                              not found
   wrimsv2.wreslplus.elements                         -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.wreslplus.elements                         -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.wreslplus.elements                         -> wrimsv2.config                                     WRIMSv2.jar
   wrimsv2.wreslplus.elements                         -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.wreslplus.elements                         -> wrimsv2.wreslplus.elements.procedures              WRIMSv2.jar
   wrimsv2.wreslplus.elements                         -> wrimsv2.wreslplus.grammar                          WRIMSv2.jar
   wrimsv2.wreslplus.elements.procedures              -> com.google.common.collect                          not found
   wrimsv2.wreslplus.elements.procedures              -> java.io                                            java.base
   wrimsv2.wreslplus.elements.procedures              -> java.lang                                          java.base
   wrimsv2.wreslplus.elements.procedures              -> java.util                                          java.base
   wrimsv2.wreslplus.elements.procedures              -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.wreslplus.elements.procedures              -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.wreslplus.elements.procedures              -> wrimsv2.components                                 WRIMSv2.jar
   wrimsv2.wreslplus.elements.procedures              -> wrimsv2.config                                     WRIMSv2.jar
   wrimsv2.wreslplus.elements.procedures              -> wrimsv2.evaluator                                  WRIMSv2.jar
   wrimsv2.wreslplus.elements.procedures              -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.wreslplus.elements.procedures              -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
   wrimsv2.wreslplus.grammar                          -> java.io                                            java.base
   wrimsv2.wreslplus.grammar                          -> java.lang                                          java.base
   wrimsv2.wreslplus.grammar                          -> java.util                                          java.base
   wrimsv2.wreslplus.grammar                          -> org.antlr.runtime                                  WRIMSv2.jar
   wrimsv2.wreslplus.grammar                          -> org.antlr.runtime.tree                             WRIMSv2.jar
   wrimsv2.wreslplus.grammar                          -> wrimsv2.commondata.wresldata                       WRIMSv2.jar
   wrimsv2.wreslplus.grammar                          -> wrimsv2.wreslparser.elements                       WRIMSv2.jar
   wrimsv2.wreslplus.grammar                          -> wrimsv2.wreslplus.elements                         WRIMSv2.jar
