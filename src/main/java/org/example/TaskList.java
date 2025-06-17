package org.example;

import org.example.linkedlist.Node;
import org.example.linkedlist.SingleLinkedList;

public class TaskList {
    private SingleLinkedList taskList;

    public TaskList(Task firstTask){
        this.taskList = new SingleLinkedList();
        this.taskList.createSingleLinkedlist(firstTask);
    }

    public void addTask(Task task){
        this.taskList.insertLinkedList(task, this.taskList.getSize());
    }

    public void setAsComplete(int locationIndex){
        Node node = taskList.searchNode(locationIndex);
        if (node != null){
            node.value.setDoneStatus(true);
        }
    }

    public String toString(){
        return taskList.traverseLinkedList();
    }
}
