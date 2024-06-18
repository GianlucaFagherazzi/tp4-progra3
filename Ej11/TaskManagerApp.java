package Ej11;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerApp extends JFrame {
    private TaskTableModel tableModel;
    private JTable taskTable;

    public TaskManagerApp() {
        setTitle("Task Manager");

        tableModel = new TaskTableModel();
        taskTable = new JTable(tableModel);
        taskTable.setRowHeight(30); // Altura de las filas
        taskTable.getTableHeader().setReorderingAllowed(false); // No permitir reordenar columnas

        // Renderizador para la columna de la casilla de verificación
        taskTable.getColumnModel().getColumn(2).setCellRenderer(new CheckBoxRenderer());
        taskTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(taskTable);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        JButton editButton = new JButton("Edit Task");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editTask();
            }
        });

        JButton deleteButton = new JButton("Delete Task");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        getContentPane().add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void addTask() {
        String taskName = JOptionPane.showInputDialog(this, "Enter task name:");
        if (taskName != null && !taskName.trim().isEmpty()) {
            String taskDescription = JOptionPane.showInputDialog(this, "Enter task description:");
            Task task = new Task(taskName, taskDescription);
            tableModel.addTask(task);
        }
    }

    private void editTask() {
        int rowIndex = taskTable.getSelectedRow();
        if (rowIndex != -1) {
            Task task = tableModel.getTask(rowIndex);
            String newTaskName = JOptionPane.showInputDialog(this, "Enter new task name:", task.getName());
            if (newTaskName != null && !newTaskName.trim().isEmpty()) {
                String newTaskDescription = JOptionPane.showInputDialog(this, "Enter new task description:", task.getDescription());
                task.setName(newTaskName);
                task.setDescription(newTaskDescription);
                tableModel.fireTableRowsUpdated(rowIndex, rowIndex);
            }
        }
    }

    private void deleteTask() {
        int rowIndex = taskTable.getSelectedRow();
        if (rowIndex != -1) {
            tableModel.deleteTask(rowIndex);
        }
    }

    private class CheckBoxRenderer extends DefaultTableCellRenderer {
        private JCheckBox checkBox = new JCheckBox();

        public CheckBoxRenderer() {
            checkBox.setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                checkBox.setSelected((Boolean) value);
            }
            return checkBox;
        }
    }
}
