package Ej11;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {
    private List<Task> tasks;
    private String[] columnNames = {"Task Name", "Description", "Completed"};

    public TaskTableModel() {
        tasks = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return task.getName();
            case 1:
                return task.getDescription();
            case 2:
                return task.isCompleted();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) { // Columna de la casilla de verificación (completed)
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2; // Permitir editar solo la columna de la casilla de verificación
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 2 && aValue instanceof Boolean) {
            Task task = tasks.get(rowIndex);
            task.setCompleted((Boolean) aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        fireTableRowsInserted(tasks.size() - 1, tasks.size() - 1);
    }

    public void deleteTask(int rowIndex) {
        tasks.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Task getTask(int rowIndex) {
        return tasks.get(rowIndex);
    }
}
