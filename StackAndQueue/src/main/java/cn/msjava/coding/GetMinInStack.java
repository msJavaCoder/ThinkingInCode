package cn.msjava.coding;
import java.util.Stack;

/**
 * msJava
 * @Title 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * @Description 设计一个有getMin功能的栈
 * @Date 2020-10-01 12:53
 */
public class GetMinInStack {

    // 正常栈
    private Stack<Integer> stackData;
    // 用于保存每一步的最小值
    private Stack<Integer> stackMin;

    public GetMinInStack(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }

    /**
     * 入栈
     * @param newNum
     */
    public void push(int newNum){
        // 1. 判断stackMin，是否为空，如果为空压入
        if(this.stackMin.isEmpty()){
            stackMin.push(newNum);
            // 2. 判断newNum是否小于stackMin栈顶的元素，如果小于将newNum压入，否则压入stackData
        }else if(newNum<this.getmin()){
            this.stackMin.push(newNum);
        }else {
            this.stackData.push(newNum);
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("你的栈为空！");
        }
        int value=this.stackData.pop();
        if(value==this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    /**
     * 获取最小元素
     * @return
     */
    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("你的栈为空！");
        }else {
            return this.stackMin.peek();
        }
    }



}
