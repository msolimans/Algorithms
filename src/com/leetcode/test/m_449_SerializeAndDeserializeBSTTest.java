package com.leetcode.test;


import com.leetcode.m_449_SerializeAndDeserializeBST;
import com.leetcode.shared.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by msoliman on 1/19/18.
 */
public class m_449_SerializeAndDeserializeBSTTest {
    @Test
    public void CodecTest(){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(3);

        node.left.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(2);
        node.left.left.left.left = new TreeNode(2);
        node.left.left.left.left.left = new TreeNode(1);

        node.right = new TreeNode(8);
        node.right.left = new TreeNode(7);
        node.right.left.left = new TreeNode(6);
        node.right.left.left.left = new TreeNode(6);

        node.right.right = new TreeNode(9);
        node.right.right.left = new TreeNode(9);
        node.right.right.left.left = new TreeNode(9);


        m_449_SerializeAndDeserializeBST.Codec codec = new m_449_SerializeAndDeserializeBST.Codec();
        //serialize (get string)
        String n1 = codec.serialize(node);

        //deserialize
        TreeNode n2 = codec.deserialize(n1);

        //serialize again (now n1 should be equal to n3)
        String n3 = codec.serialize(n2);


        Assert.assertEquals(n1,n3);
    }

    @Test
    public void Serialize(){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(3);

        node.left.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(2);
        node.left.left.left.left = new TreeNode(2);
        node.left.left.left.left.left = new TreeNode(1);

        node.right = new TreeNode(8);
        node.right.left = new TreeNode(7);
        node.right.left.left = new TreeNode(6);
        node.right.left.left.left = new TreeNode(6);

        node.right.right = new TreeNode(9);
        node.right.right.left = new TreeNode(9);
        node.right.right.left.left = new TreeNode(9);


        m_449_SerializeAndDeserializeBST.Codec codec = new m_449_SerializeAndDeserializeBST.Codec();
        //serialize (get string)
        String n1 = codec.serialize(node);

        Assert.assertEquals("5/2,3,2/2,1,4,8,7,6/2,9/3", n1);


    }


}
