
package phanmemnghenhac;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.player.Player;

public class PhanMemNgheNhac extends javax.swing.JFrame {
    JFileChooser dialogUrl = new JFileChooser();
    String fileName;
    Player player;
    Thread threadingPlaying; // Luồng mở bài hát
    Thread threadingStrackBar; // Luồng chạy slider
    int max = 0;
    
    Vector headerTitleTable = new Vector();
    Vector data = new Vector();
    DefaultTableModel tblModel;
    
    String fileList = "song.txt";
    JLabel pic;
    Timer tm;
    int x = 0;
    String[] listPic = {
        "images\\pic1.jpg",
        "images\\pic2.jpg",
        "images\\pic3.jpg",
        "images\\pic4.jpg",
        "images\\pic5.jpg"
    };
    
    public PhanMemNgheNhac() {
        initComponents();
        setResizable(false);
        loadSong();
        
        headerTitleTable.add("Tên bài hát");
        headerTitleTable.add("Thời lượng");
        headerTitleTable.add("Vị trí");
        
        tblModel = (DefaultTableModel) tblSongList.getModel();
        tblModel.setDataVector(data, headerTitleTable);
        
        pic = new JLabel();
        pic.setBounds(0, 0, 662, 243);
        setImageSize(4);
        tm = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setImageSize(x);
                x += 1;
                if (x >= listPic.length)
                {
                    x = 0;
                }
            }
        });
        pnPicture.add(pic);
        tm.start();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        btnOpen = new javax.swing.JButton();
        sliderProgress = new javax.swing.JSlider();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSongList = new javax.swing.JTable();
        pnPicture = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuOpen = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuPlay = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuStop = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAbout = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Tập tin đang mở");

        btnOpen.setBackground(new java.awt.Color(255, 255, 255));
        btnOpen.setText("Browse url...");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        sliderProgress.setValue(0);

        btnStart.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnAdd.setText("Thêm bài hát");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnSave.setText("Lưu bài hát");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        btnDelete.setText("Xóa khỏi danh sách");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblSongList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSongList.setToolTipText("Danh sách bài hát");
        tblSongList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSongListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSongListMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSongList);

        javax.swing.GroupLayout pnPictureLayout = new javax.swing.GroupLayout(pnPicture);
        pnPicture.setLayout(pnPictureLayout);
        pnPictureLayout.setHorizontalGroup(
            pnPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnPictureLayout.setVerticalGroup(
            pnPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        mnuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnuOpen.setText("Chọn tập tin");
        mnuOpen.setPreferredSize(new java.awt.Dimension(200, 22));
        jMenu1.add(mnuOpen);
        jMenu1.add(jSeparator2);

        mnuPlay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuPlay.setText("Mở bài hát");
        mnuPlay.setPreferredSize(new java.awt.Dimension(200, 22));
        jMenu1.add(mnuPlay);
        jMenu1.add(jSeparator3);

        mnuStop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnuStop.setText("Kết thúc");
        mnuStop.setPreferredSize(new java.awt.Dimension(200, 22));
        jMenu1.add(mnuStop);
        jMenu1.add(jSeparator4);

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnuExit.setText("Thoát ứng dụng");
        mnuExit.setPreferredSize(new java.awt.Dimension(200, 22));
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        mnuAbout.setText("Thông tin ứng dụng");
        jMenu2.add(mnuAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(138, 138, 138))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUrl)
                                    .addComponent(sliderProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(btnStart)
                    .addContainerGap(727, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtUrl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStop)
                    .addComponent(btnAdd)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(btnStart)
                    .addContainerGap(451, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setImageSize(int n){
        ImageIcon icon = new ImageIcon(listPic[n]);
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(pnPicture.getWidth(), pnPicture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        pic.setIcon(newIcon);
        
    }
    
    private void loadSong(){
        try{
            FileReader in = new FileReader(fileList);
            BufferedReader buf = new BufferedReader(in);
            String song;
            while((song = buf.readLine()) != null)
            {
                String info[] = song.split(",");
                String name = info[0];
                String time = info[1];
                String location = info[2];
                
                Vector row = new Vector();
                row.add(name);
                row.add(time);
                row.add(location);
                data.add(row);   
            }
            buf.close();
            in.close();
        }catch(Exception e)
        {
            
        }
    }
    
    private int getDuration(File f)
    {
        int mili = 0;
        int sec = 0;
        try {
            // Lay ra thoi luong cung nhu cac thong tin khac cua file audio
            AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(f);
            long microSecond = (long) fileFormat.properties().get("duration");
            mili = (int) (microSecond/100);
            sec = (int) mili/1000;
        
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PhanMemNgheNhac.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PhanMemNgheNhac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sec;
    }
    
    private String getDurationFormat(File f) throws Exception{
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(f);
        long microSecond = (long) fileFormat.properties().get("duration");
        long sec = TimeUnit.MICROSECONDS.toSeconds(microSecond);
        long minute = TimeUnit.MICROSECONDS.toMinutes(microSecond);
        long hour = TimeUnit.MICROSECONDS.toHours(microSecond);
        
        return hour + " : " + minute + " : " + sec;
    }
    private void addFileToTable(File[] f) throws Exception{
        for (File song: f)
        {
            String musicDuration = getDurationFormat(song);
            String musicTitle = song.getName();
            String musicLocation = song.getCanonicalPath();
            
            Vector v = new Vector();
            v.add(musicTitle);
            v.add(musicDuration);
            v.add(musicLocation);
            data.add(v);
        }
        tblSongList.updateUI();
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       int res = JOptionPane.showConfirmDialog(null
               , "Bạn có chắc thoát ứng dụng không?"
               ,"Xác nhận"
               , JOptionPane.YES_NO_OPTION);
       if (res == JOptionPane.YES_OPTION)
       {
           System.exit(0);
       }
       else
       {
           setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       }
    }//GEN-LAST:event_formWindowClosing

    private void tblSongListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSongListMouseReleased
        // Không cho chỉnh sửa trên bảng
        if (tblSongList.isEditing())
        {
            int row = tblSongList.getSelectedRow();
            int coloumn = tblSongList.getSelectedColumn();
            tblSongList.getCellEditor(row, coloumn).cancelCellEditing();
        }
    }//GEN-LAST:event_tblSongListMouseReleased

    private void tblSongListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSongListMouseClicked
        int row = tblSongList.getSelectedRow();
        String location = tblSongList.getValueAt(row, 2).toString();
        txtUrl.setText(location);
        if (evt.getClickCount() == 2)
        {
            if (threadingPlaying != null)
            {
                btnStopActionPerformed(null);
            }
            btnStartActionPerformed(null);
        }
    }//GEN-LAST:event_tblSongListMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int pos = tblSongList.getSelectedRow();
        if (pos >= 0)
        {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION)
            {
                data.remove(pos);
                tblSongList.updateUI();;
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            File f = new File(fileList);
            PrintWriter out = new PrintWriter(f);
            int n = data.size();
            for(int i = 0;i < n;++i)
            {
                Vector row = (Vector) data.get(i);
                String s = row.get(0) + "," + row.get(1) + "," + row.get(2);
                out.println(s);
            }
            out.close();
        }catch(Exception e)
        {
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dialogUrl.setMultiSelectionEnabled(true);
        int result = dialogUrl.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File[] f = dialogUrl.getSelectedFiles();
            try{
                addFileToTable(f);
            }catch(Exception e)
            {

            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (player != null)
        {
            player.close();
        }
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        sliderProgress.setValue(0);

        threadingPlaying.interrupt();
        threadingStrackBar.interrupt();
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        fileName = txtUrl.getText();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        File f = new File(fileName);
        try{
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            max = getDuration(f);
            sliderProgress.setMaximum(max);
        }
        catch(Exception e){ }
        // Nếu không có đa luồng thì không mở được bài hát và không dừng, mở bài khác tiếp
        threadingPlaying = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    player.play();

                }catch(Exception e){    }
            }
        });

        threadingStrackBar = new Thread(new Runnable() {
            @Override
            public void run() {
                int n = 0;
                while(!player.isComplete() && threadingPlaying.isAlive())
                {
                    try {
                        sliderProgress.setValue(++n);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) { }
                }
                sliderProgress.setValue(max);
                btnStopActionPerformed(null);
            }
        });

        threadingPlaying.start();
        threadingStrackBar.start();
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        try{
            int result = dialogUrl.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File f = dialogUrl.getSelectedFile();
                if (f.isFile())
                {
                    this.txtUrl.setText(f.getCanonicalPath()); // get url file
                }
            }
        }catch(Exception e)
        {

        }
    }//GEN-LAST:event_btnOpenActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhanMemNgheNhac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JMenuItem mnuPlay;
    private javax.swing.JMenuItem mnuStop;
    private javax.swing.JPanel pnPicture;
    private javax.swing.JSlider sliderProgress;
    private javax.swing.JTable tblSongList;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
