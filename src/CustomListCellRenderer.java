
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cody
 */
public class CustomListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
    JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Item) {
            value = ((Item)value).getDescription();
        }
        super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        return this;
    }
}
