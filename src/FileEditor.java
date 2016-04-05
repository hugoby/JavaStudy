import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class FileEditor extends WindowAdapter implements ActionListener,TextListener{
  Frame f;  TextArea ta1;
  Panel p1;  TextField tf1;
  JButton b1,b2; 
  FileDialog fd;
  File file1 = null;
  public static void main(String args[]){
    (new FileEditor()).display();
  }
  public void display(){
    f = new Frame("文件");//对框架（对话窗口）进行相关的属性设置
    f.setSize(500,400);
    f.setLocation(200,140);
    f.setBackground(Color.green);
    f.addWindowListener(this);
    
    tf1 = new TextField();//对文本域进行相关的属性设置
    tf1.setEnabled(false);
    tf1.setFont(new Font("Dialog",1,20)); //设置文本行的初始字体
    f.add(tf1,"North");
    
    ta1 = new TextArea();//对文本区进行相关的属性设置
    ta1.setFont(new Font("Dialog",1,20)); //设置文本区的初始字体
    f.add(ta1);
    ta1.addTextListener(this); //Hugo:注册文本区的事件监听程序
    
    p1 = new Panel();//对面板进行相关的属性设置
    p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    b1=new JButton("打开");
    b2 = new JButton("保存");
    p1.add(b1);p1.add(b2);//添加按钮到面板上
    b2.setEnabled(false); 
    b1.addActionListener(this); //注册按钮的事件监听程序
    b2.addActionListener(this);
    f.add(p1,"South");
    f.setVisible(true);
  } //display结束
  
  public void textValueChanged(TextEvent e){ //实现TextListener接口中的方法，对文本区操作时触发
    b2.setEnabled(true);
  }
  
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==b1) { //单击[打开]按钮时
      fd = new FileDialog(f, "Open", FileDialog.LOAD);
      fd.setVisible(true); //创建并显示打开文件对话框
      if ((fd.getDirectory() != null) && (fd.getFile() != null)) {
        file1 = new File(fd.getDirectory(), fd.getFile());
        try {
          InputStream istream = new FileInputStream(file1);
          //WordExtractor doc=new WordExtractor(istream);

          String path = file1.getPath();
          FileInputStream fileInputStream = new FileInputStream(path);
          HWPFDocument doc = new HWPFDocument(fileInputStream);
          //String text=ex.getText();
          //ta1.append(text);
          String text = doc.getDocumentText();
          ta1.append(text);

          org.apache.poi.hwpf.usermodel.Range range = doc.getRange();
          int numP = range.numParagraphs();
          System.out.println("number of CharacterRun " + numP);

          byte[] dateStream = doc.getDataStream();
          POIFSFileSystem filesystem = new POIFSFileSystem(istream);
          DocumentEntry documentProps = (DocumentEntry) filesystem.getRoot().getEntry("WordDocument");
          byte[] mainStream = new byte[documentProps.getSize()];
          System.out.println("size of dateStream " + dateStream.length);
          int numChar = range.numCharacterRuns();
          System.out.println("number of CharacterRun " + numChar);
          PicturesTable pTable = new PicturesTable(doc, dateStream, mainStream);
          for (int i = 0; i < numChar; i++) {
            CharacterRun cRun = range.getCharacterRun(i);
            boolean has = pTable.hasPicture(cRun);
            System.out.println("hasPicture " + has);
            if (has) {
              Picture pic = pTable.extractPicture(cRun, true);
              try {
                FileOutputStream out=new FileOutputStream("f:/" + i + ".bmp");
                pic.writeImageContent(out);
                out.toString();


                System.out.println(pic.suggestPictureType().getExtension());
                System.out.println("Successfully get the picture");


              } catch (IOException e1) {
                e1.printStackTrace();
              }
              System.out.println("extract Picture successfully! ");
            }
          }
        } //内层if结束
        catch (FileNotFoundException e1) {
          e1.printStackTrace();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      } //外层if结束
      if ((e.getSource() == b2) && (file1 == null)) { //单击[保存]按钮时
        fd = new FileDialog(f, "Save", FileDialog.SAVE);
        if (file1 == null)
          fd.setFile("Edit1.txt");
        else
          fd.setFile(file1.getName());
        fd.setVisible(true); //创建并显示保存文件对话框
        if ((fd.getDirectory() != null) && (fd.getFile() != null)) {
          tf1.setText(fd.getDirectory() + fd.getFile());
          file1 = new File(fd.getDirectory(), fd.getFile());
          save(file1);
        } //内层if结束
      } //中层if结束
      else
        save(file1);
    }
  } //方法actionPerformed结束


  public void save(File file1){
    try{ //将文本区内容写入字符输出流
      FileWriter fw = new FileWriter(file1);
      fw.write(ta1.getText());
      fw.close();
      b2.setEnabled(false);
    } //try结束
    catch (IOException ioe){
      System.out.println(ioe);
    } //catch结束
  }//方法save结束


  public void windowClosing(WindowEvent e){
    System.exit(0);
  } //方法windowClosing结束
} //主类（即程序）结束


