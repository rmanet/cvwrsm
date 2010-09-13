/*

Copyright (C) 1998, 2000 State of California, Department of Water Resources.

This program is licensed to you under the terms of the GNU General Public
License, version 2, as published by the Free Software Foundation.

You should have received a copy of the GNU General Public License along
with this program; if not, contact Dr. Sushil Arora, below, or the
Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.

THIS SOFTWARE AND DOCUMENTATION ARE PROVIDED BY THE CALIFORNIA DEPARTMENT
OF WATER RESOURCES AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE CALIFORNIA DEPARTMENT OF WATER RESOURCES OR ITS
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OR SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA OR PROFITS;
OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

For more information, contact:

Dr. Sushil Arora
California Dept. of Water Resources
Office of State Water Project Planning, Hydrology and Operations Section
1416 Ninth Street
Sacramento, CA  95814
916-653-7921
sushil@water.ca.gov

*/

package calsim.gui;
//import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
//import java.io.*;

/**
 * The tabbed pane of Calsim OAS GUI, which contains main panel, schematic editor, etc.
 *
 * @author YanPing Zuo
 * @version $Id: TabbedPane.java,v 1.1.2.14 2001/07/12 02:00:01 amunevar Exp $
 */

public class TabbedPane
{
  public static boolean DEBUG = true;

  /**
   * constructor
   * create a tabbed pane, which contains several tabs of main panel, schematic editor, etc.
   */
  public TabbedPane(JFrame fr) {
    _fr = fr;
    _tabbedPane = createTabbedPane();
  }

  /**
   * create the tabbed pane
   */
  JTabbedPane createTabbedPane() {
    _tabbedPane = new JTabbedPane();
    JPanel jPanel = new JPanel();
    jPanel .setLayout(new BorderLayout());
    jPanel.setBackground(new Color(229,240,203));
    jPanel.add(GuiUtils.createStudyTab());
    _tabbedPane.addTab("Study   ", null, jPanel, "Study tabbed pane");
    _tabbedPane.addTab("Output    ", null, GuiUtils.createMainPanel(_fr), "OutPut panel");
    return _tabbedPane;
  }

  /**
   * Return the Node/Arc/General menu bar
   */
  public JTabbedPane getTabbedPane(){
    return _tabbedPane;
  }
  /**
   *
   */
  private JTabbedPane _tabbedPane;
  private JFrame _fr;
}

