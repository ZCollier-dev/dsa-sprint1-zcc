package org.example;

import org.example.linkedlist.SingleLinkedList;

//Includes methods to add a task, mark a task as completed, and print all tasks.

public class TaskList {
    private SingleLinkedList taskList;

    public TaskList(Task firstTask){
        this.taskList.createSingleLinkedlist(firstTask);
    }
}
