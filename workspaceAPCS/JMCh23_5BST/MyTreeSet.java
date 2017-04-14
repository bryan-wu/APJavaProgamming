import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A home grown MyTreeSet grown in the rich and airy lands of Scotland.
 *
 * @author Bryan Wu
 * @version Jan 26, 2016
 * @author Period: 3
 * @author Assignment: JMCh23_5BST
 *
 * @author Sources: None
 */
public class MyTreeSet<E> implements Iterable<E>
{
    private TreeNode<E> root; // holds the root of
                              // this BST


    /**
     * Constructor: creates an empty BST.
     */
    public MyTreeSet()
    {
        root = null;
    }


    /**
     * Returns true if this BST contains value; otherwise returns false.
     * 
     * @param value
     *            value
     * @return if value contained
     */
    public boolean contains( E value )
    {
        return contains( root, value );
    }


    /**
     * Adds value to this BST, unless this tree already holds value.
     * 
     * @param value
     *            value
     * @return Returns true if value has been added; otherwise returns false.
     */
    public boolean add( E value )
    {
        if ( contains( value ) )
        {
            return false;
        }
        root = add( root, value );
        return true;
    }


    /**
     * Removes value from this BST.
     * 
     * @param value
     *            value
     * @return Returns true if value has been found and removed; otherwise
     *         returns false.
     */
    public boolean remove( E value )
    {
        if ( !contains( value ) )
            return false;
        root = remove( root, value );
        return true;
    }


    /**
     * @return Returns a string representation of this BST.
     */
    public String toString()
    {
        String str = toString( root );
        if ( str.endsWith( ", " ) )
        {
            str = str.substring( 0, str.length() - 2 );
        }
        return "[" + str + "]";
    }


    /**
     * @return Returns an iterator for this BST.
     */
    public Iterator<E> iterator()
    {
        return new MyTreeSetIterator( root );
    }

    // *************** Private helper methods: *********************


    // Returns true if the BST rooted at node contains value;
    // otherwise returns false (recursive version).
    /**
     * Returns true if the BST rooted at node contains value; otherwise returns
     * false (recursive version).
     * 
     * @param node
     *            node
     * @param value
     *            value
     * @return Returns true if the BST rooted at node contains value; otherwise
     *         returns false (recursive version).
     */
    private boolean contains( TreeNode<E> node, E value )
    {
        if ( node == null )
            return false;
        else
        {
            @SuppressWarnings("unchecked")
            int diff = ( (Comparable<E>)value ).compareTo( node.getValue() );
            if ( diff == 0 )
            {
                return true;
            }
            else if ( diff < 0 )
            {
                return contains( node.getLeft(), value );
            }
            else // if (diff > 0)
            {
                return contains( node.getRight(), value );
            }
        }
    }

    /*
     * // Iterative version: private boolean contains(TreeNode<E> node, E value)
     * { while (node != null) { int diff = ( (Comparable<E>)value).compareTo(
     * node.getValue() ); if (diff == 0) return true; else if (diff < 0) node =
     * node.getLeft(); else // if (diff > 0) node = node.getRight(); } return
     * false; }
     */


    /**
     * Adds value to the BST rooted at node. Precondition: the tree rooted at
     * node does not contain value.
     * 
     * @param node
     *            node
     * @param value
     *            value
     * @return Returns the root of the new tree.
     */
    private TreeNode<E> add( TreeNode<E> node, E value )
    {
        if ( node == null )
            node = new TreeNode<E>( value );
        else
        {
            @SuppressWarnings("unchecked")
            int diff = ( (Comparable<E>)value ).compareTo( node.getValue() );
            if ( diff < 0 )
            {
                node.setLeft( add( node.getLeft(), value ) );
            }
            else
            {
                node.setRight( add( node.getRight(), value ) );
            }
        }
        return node;
    }


    /**
     * Removes value from the BST rooted at node. Precondition: the tree rooted
     * at node contains value.
     * 
     * @param node
     *            node
     * @param value
     *            value
     * @return Returns the root of the new tree.
     */
    private TreeNode<E> remove( TreeNode<E> node, E value )
    {
        @SuppressWarnings("unchecked")
        int diff = ( (Comparable<E>)value ).compareTo( node.getValue() );
        if ( diff == 0 ) // base case
        {
            node = removeRoot( node );
        }
        else if ( diff < 0 )
        {
            node.setLeft( remove( node.getLeft(), value ) );
        }
        else // if (diff > 0)
        {
            node.setRight( remove( node.getRight(), value ) );
        }
        return node;
    }


    /**
     * Removes the root of the BST rooted at root replacing it with the smallest
     * node from the right subtree.
     * 
     * @param root
     * @return Returns the root of the new tree.
     */
    private TreeNode<E> removeRoot( TreeNode<E> root )
    {
        TreeNode<E> right = root.getRight();
        TreeNode<E> left = root.getLeft();
        TreeNode<E> prev = null;

        if ( right == null )
        {
            return left;
        }
        else if ( left == null )
        {
            return right;
        }
        if ( right.getLeft() == null )
        {
            root.setValue( root.getRight().getValue() );
            root.setRight( root.getRight().getRight() );
            return root;
        }
        while ( right.getLeft() != null )
        {
            prev = right;
            right = right.getLeft();
        }
        root.setValue( right.getValue() );
        root = new TreeNode<E>( right.getValue(), root.getLeft(), root.getRight() );
        TreeNode<E> otherRight = right.getRight();
        if ( otherRight != null )
        {
            right = new TreeNode<E>( otherRight.getValue(), otherRight.getLeft(), otherRight.getRight() );
            prev.setLeft( right );
        }
        else
        {
            prev.setLeft( null );
        }
        return root;
    }


    /**
     * Utility routine to print the structure of the BST
     */
    public void printSideways()
    {
        if ( root == null )
        {
            return;
        }
        printSideways( root, 0 );
    }


    /**
     * Precondition: original argument != null
     * 
     * @param t
     *            treenode
     * @param depth
     *            depth
     */
    private void printSideways( TreeNode<E> t, int depth )
    {
        if ( t.getRight() != null )
        {
            printSideways( t.getRight(), depth + 1 );
        }
        process( t.getValue(), depth );
        if ( t.getLeft() != null )
        {
            printSideways( t.getLeft(), depth + 1 );
        }
    }


    /**
     * Simply display the toString version of my_data
     * 
     * @param obj
     *            object
     * @param depth
     *            depth
     */
    private void process( E obj, int depth )
    {
        for ( int j = 1; j <= depth; j++ )
        {
            System.out.print( "    " );
        }
        System.out.println( obj.toString() );
    }


    /**
     * Returns a string representation of the tree rooted at node.
     * 
     * @param node
     *            node
     * @return Returns a string representation of the tree rooted at node.
     */
    private String toString( TreeNode<E> node )
    {
        if ( node == null )
        {
            return "";
        }
        else
        {
            return toString( node.getLeft() ) + node.getValue() + ", " + toString( node.getRight() );
        }
    }


    /**
     * Implements an Iterator for this tree.
     *
     * @author Bryan Wu
     * @version Jan 26, 2016
     * @author Period: 3
     * @author Assignment: JMCh23_5BST
     *
     * @author Sources: None
     */
    private class MyTreeSetIterator implements Iterator<E>
    {
        private TreeNode<E> node;

        @SuppressWarnings("rawtypes")
        private Stack<TreeNode> stk;


        /**
         * @param root
         *            root
         */
        @SuppressWarnings({ "rawtypes" })
        public MyTreeSetIterator( TreeNode<E> root )
        {
            stk = new Stack<TreeNode>();
            node = root;

            while ( node != null )
            {
                stk.push( node );
                node = node.getLeft();
            }
        }


        /**
         * @return if hasNext
         */
        public boolean hasNext()
        {
            if ( stk.isEmpty() )
            {
                return false;
            }
            return true;
        }


        /**
         * @return next element
         */
        @SuppressWarnings("unchecked")
        public E next()
        {
            if ( hasNext() )
            {
                node = stk.pop();
                Object obj = node.getValue();
                node = node.getRight();
                while ( node != null )
                {
                    stk.push( node );
                    node = node.getLeft();
                }
                return (E)obj;
            }
            else
            {
                throw new NoSuchElementException();
            }
        }


        /**
         * Remove it.
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }


    // ************************** main: **************************

    public static void main( String[] args )
    {
        String[] words = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
        MyTreeSet<String> bst = new MyTreeSet<String>();

        for ( String word : words )
        {
            System.out.println( "Added: " + word + " " + bst.add( word ) );
            System.out.println( "Contains: " + word + " " + bst.contains( word ) );
            if ( bst.add( word ) )
                System.out.println( "*** Added a duplicate value ***" );
            System.out.println( bst );
        }
        bst.printSideways();

        System.out.println( "Traversal with an iterator:" );
        for ( Object obj : bst )
            System.out.print( obj + " " );
        System.out.println();

        for ( String word : words )
        {
            System.out.println( "Removed: " + word + " " + bst.remove( word ) );
            if ( bst.remove( word ) )
                System.out.println( "*** Removed a non-existent value ***" );
            System.out.println( bst );
            bst.printSideways();
        }
    }
}
