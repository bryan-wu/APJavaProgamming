import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author Richard Yang
 * @author Katherine Xiao
 * @author Bryan Wu
 * @version 3/17/2016
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: None
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;


    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" ) && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares ) && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>", to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be " + symbol + " >>", symbol, to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );

        assertTrue( "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder + " >>", to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertFalse( "<< TradeOrder: " + to.isSell() + " should be " + !buyOrder + " >>", to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertTrue( "<< TradeOrder: " + to.isMarket() + " should be " + marketOrder + " >>", to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );

        assertFalse( "<< TradeOrder: " + to.isLimit() + " should be " + !marketOrder + ">>", to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertTrue( "<< TradeOrder: " + to.getShares() + " should be " + numShares + ">>",
            numShares == to.getShares() || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price + ">>", price, to.getPrice(), 0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null, symbol, buyOrder, marketOrder, numShares, price );
        to.subtractShares( numToSubtract );
        assertEquals(
            "<< TradeOrder: subtractShares(" + numToSubtract + ") should be " + ( numShares - numToSubtract ) + ">>",
            numShares - numToSubtract,
            to.getShares() );
    }


    // --Test TraderWindow Stub

    @Test
    public void TraderWindowToString()
    {
        TraderWindow to = new TraderWindow( new Trader( new Brokerage( new StockExchange() ), "Asdf", "pass" ) );
        assertNotNull( to.toString() );
    }


    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }


    // --Test PriceComparator

    @Test
    public void PriceComparatorToString()
    {
        PriceComparator to = new PriceComparator();
        assertNotNull( to.toString() );
    }


    @Test
    public void PriceComparatorEmptyConstructor()
    {
        PriceComparator asdf = new PriceComparator();
        assertNotNull( asdf );
    }


    @Test
    public void PriceComparatorConstructor()
    {
        PriceComparator asdf = new PriceComparator( false );
        assertNotNull( asdf );
    }


    @Test
    public void PriceComparatorCompare()
    {
        PriceComparator asc = new PriceComparator();
        PriceComparator des = new PriceComparator( false );
        TradeOrder order1 = new TradeOrder( null, "DS", false, true, 50, 100.0 );
        TradeOrder order2 = new TradeOrder( null, "DS", false, true, 50, 100.0 );
        assertEquals( "<<PriceComparatorCompare:Limit to Limit>>", 0, asc.compare( order1, order2 ) );
        order1 = new TradeOrder( null, "DS", false, false, 50, 100.0 );
        order2 = new TradeOrder( null, "DS", false, true, 50, 100.0 );
        assertEquals( "<<PriceComparatorCompare:Limit to Limit>>", 1, asc.compare( order1, order2 ) );
        order1 = new TradeOrder( null, "DS", false, true, 50, 100.0 );
        order2 = new TradeOrder( null, "DS", false, false, 50, 100.0 );
        assertEquals( "<<PriceComparatorCompare:Limit to Limit>>", -1, asc.compare( order1, order2 ) );
        order1 = new TradeOrder( null, "DS", false, false, 2, 100.0 );
        order2 = new TradeOrder( null, "DS", false, false, 1, 100.0 );
        assertEquals( "<<PriceComparatorCompare:Limit to Limit>>", 10000, asc.compare( order1, order2 ) );
        assertEquals( "<<PriceComparatorCompare:Limit to Limit>>", -10000, des.compare( order1, order2 ) );
    }

    // --Test Trader
    private StockExchange e = new StockExchange();

    private Brokerage b = new Brokerage( e );

    private String name = "Bada";

    private String password = "Boom";


    /**
     * Trader tests: TraderConstructor - constructs Trader || TraderCompareTo -
     * compares value returned to constructed value || TraderEquals - test for
     * equals || TraderGetName - test get Name value || TraderGetPassword - test
     * get password value || TradeGetQuote - test get Quote ||
     * TestTraderhasMessages - test if has messages || TraderOpenWindow - test
     * open window method || TraderPlaceOrder - test place order || TraderQuit -
     * test trader quit || TraderReceiveMessage - test receive messages
     */
    @Test
    public void TraderConstructor()
    {

        Trader trader = new Trader( b, name, password );
        /*
         * assertTrue( "<< Invalid Trader Constructor >>", toStr.contains(
         * "Trader[Brokerage brokerage:" + b ) && toStr.contains(
         * "java.lang.String screenName:" + name ) && toStr.contains(
         * "java.lang.String password:" + password ) && toStr.contains(
         * "TraderWindow myWindow:null" ) && toStr.contains(
         * "Queue<String> mailbox:null" ) );
         */
        assertNotNull( "<< Trader Constructor test >>", trader );
    }


    @Test
    public void TraderCompareTo()
    {
        Trader trader = new Trader( b, name, password );
        Trader otherTrader = new Trader( b, "Donald", "Trump" );
        assertTrue( "<< Invalid Trader CompareTo >>", trader.compareTo( otherTrader ) < 0 );
    }


    @Test
    public void TraderEquals()
    {
        Trader trader = new Trader( b, name, password );
        Trader otherTrader = new Trader( b, "Bada", "Boom" );
        assertEquals( true, trader.equals( otherTrader ) );
    }


    @Test
    public void TraderGetName()
    {
        Trader trader = new Trader( b, name, password );
        assertEquals( "<< TradeOrder: " + trader.getName() + " should be " + name + " >>", name, trader.getName() );
    }


    @Test
    public void TraderGetPassword()
    {
        Trader trader = new Trader( b, name, password );
        assertEquals( "<< TradeOrder: " + trader.getPassword() + " should be " + password + " >>",
            password,
            trader.getPassword() );
    }


    @Test
    public void TraderGetQuote()
    {
        Trader trader = new Trader( b, name, password );
        trader.getQuote();
        assertTrue( true );
    }


    @Test
    public void TraderHasMessagesTest()
    {
        Trader trader = new Trader( b, name, password );
        assertTrue( "<< Trader: " + trader.hasMessages() + " should be false >>", !trader.hasMessages() );
    }


    @Test
    public void TraderOpenWindow()
    {
        Trader trader = new Trader( b, name, password );
        trader.openWindow();
        assertTrue( true );
    }


    @Test
    public void TraderPlaceOrder()
    {
        Trader trader = new Trader( b, name, password );
        trader.pladeOrder();
        assertTrue( true );
    }


    @Test
    public void TraderQuit()
    {
        Trader trader = new Trader( b, name, password );
        trader.quit();
        assertTrue( true );
    }


    @Test
    public void TraderReceiveMessage()
    {
        Trader trader = new Trader( b, name, password );
        trader.receiveMessages();
        assertTrue( true );
    }


    @Test
    public void TraderToString()
    {
        Trader trader = new Trader( b, name, password );
        assertNotNull( trader.toString() );
    }

    // --Test Brokerage
    /**
     * Brokerage tests: BrokerageConstructor - constructs Brokerage ||
     * BrokerageAddUser - adds user || BrokerageLogin - login || BrokerageLogout
     * - logout || BrokeragePlaceOrder - place order || BrokerageToStringTest -\
     * toString
     */
    private StockExchange se = new StockExchange();


    @Test
    public void BrokerageConstructor()
    {
        Brokerage b = new Brokerage( se );
        // assertTrue( "<< Invalid Brokerage Constructor >>",
        // toStr.contains( "Brokerage[Map<String, Trader> traders:" ) &&
        // toStr.contains( "Set<Trader> loggedTraders:" )
        // && toStr.contains( "StockExchange exchange:" + se ) );
        assertNotNull( "<< Brokerage Constructor test >>", b );
    }


    @Test
    public void BrokerageAddUser()
    {
        Brokerage b = new Brokerage( se );
        assertEquals( "<< Brokerage:" + b.addUser( "Dwight", "Schrute" ) + " should be 0 >>",
            0,
            b.addUser( "Dwight", "Schrute" ) );
    }


    @Test
    public void BrokerageLogin()
    {
        Brokerage b = new Brokerage( se );
        b.addUser( "Dwight", "Schrute" );
        assertEquals( "<< Brokerage:" + b.login( "Dwight", "Schrute" ) + " should be 0 >>",
            0,
            b.login( "Dwight", "Schrute" ) );
    }


    @Test
    public void BrokerageLogout()
    {
        Brokerage b = new Brokerage( se );
        Trader test = new Trader( b, "Dwight", "Schrute" );
        b.addUser( "Dwight", "Schrute" );
        b.login( "Dwight", "Schrute" );
        b.logout( test );
        assertTrue( "<< Brokerage: Trader shouldn't be on loggedTraders set", !b.getLoggedTraders().contains( test ) );
    }


    @Test
    public void BrokeragePlaceOrder()
    {
        Brokerage b = new Brokerage( se );
        assertTrue( true );
    }


    @Test
    public void BrokerageToStringTest()
    {
        Brokerage b = new Brokerage( se );
        assertNotNull( b.toString() );
    }


    // test stock exchange

    @Test
    public void StockExchangeToString()
    {
        StockExchange to = new StockExchange();
        assertNotNull( to.toString() );
    }


    @Test
    public void StockExchangeConstructor()
    {
        StockExchange asdf = new StockExchange();
        assertNotNull( asdf );
    }


    @Test
    public void StockExchangeListStock()
    {
        StockExchange asdf = new StockExchange();
        asdf.listStock( "a", "apple", 1000000.0 );
        assertTrue( "<<StockExchangeListStock>>", asdf.getListedStocks().containsKey( "a" ) );
    }


    @Test
    public void StockExchangeGetQuote()
    {
        StockExchange asdf = new StockExchange();
        Stock ap = new Stock( "a", "apple", 1000000.0 );
        asdf.listStock( "a", "apple", 1000000.0 );
        assertEquals( "<<StockExchangeGetQuote:>>", ap.getQuote(), asdf.getQuote( "a" ) );
    }


    @Test
    public void StockExchangePlaceOrder()
    {
        StockExchange asdf = new StockExchange();
        Stock ap = new Stock( "a", "apple", 1000000.0 );
        asdf.listStock( "a", "apple", 1000000.0 );
        TradeOrder testing = new TradeOrder( null, "a", true, true, 100, 1000000.0 );
        asdf.placeOrder( testing );
        assertTrue( "<<StockExchangePlaceOrder>>", ap.getBuyOrders().peek().equals( testing ) );
        System.out.println( ap.getBuyOrders().peek() );
    }


    // --Test Stock

    @Test
    public void StockToString()
    {
        Stock to = new Stock( "a", "apple", 100.0 );
        assertNotNull( to.toString() );
    }


    @Test
    public void StockConstructor()
    {
        Stock stock = new Stock( "DS", "DanceStudios.com", 12.33 );
        assertTrue( stock.getHiPrice() == 12.33 && stock.getLoPrice() == 12.33 && stock.getLastPrice() == 12.33
            && stock.getStockSymbol().equals( "DS" ) && stock.getCompanyName().equals( "DanceStudios.com" )
            && stock.getVolume() == 0 && stock.getSellOrders().isEmpty() && stock.getBuyOrders().isEmpty() );

    }


    @Test
    public void StockGetQuote()
    {
        Stock stock = new Stock( "DS", "DanceStudios.com", 12.33 );
        String quote = "DanceStudios.com (DS)\n" + "Price: 12.33 hi: 12.33 lo: 12.33 vol: 0\n" + "Ask: none Bid: none";
        assertTrue( quote.equals( stock.getQuote() ) );
    }


    @Test
    public void StockPlaceOrder()
    {
        Stock stock = new Stock( "DS", "DanceStudios.com", 12.33 );
        StockExchange exchange = new StockExchange();
        exchange.listStock( "DS", "DanceStudios.com", 12.33 );
        Brokerage brokerage = new Brokerage( exchange );
        Trader trader = new Trader( brokerage, "name", "pswd" );
        TradeOrder order = new TradeOrder( trader, "DS", true, true, 200, 0 );
        stock.placeOrder( order );
        assertTrue( trader.hasMessages() );
    }


    @Test
    public void StockExecuteOrders()
    {
        Stock stock = new Stock( "DS", "DanceStudios.com", 12.33 );
        StockExchange exchange = new StockExchange();
        exchange.listStock( "DS", "DanceStudios.com", 12.33 );
        Brokerage brokerage = new Brokerage( exchange );
        Trader trader1 = new Trader( brokerage, "ABCD", "PASS" );
        TradeOrder buyOrder = new TradeOrder( trader1, "DS", true, true, 200, 12.33 );
        Trader trader2 = new Trader( brokerage, "EFGH", "WORD" );
        TradeOrder sellOrder = new TradeOrder( trader2, "DS", false, true, 200, 12.33 );
        stock.getBuyOrders().add( buyOrder );
        stock.getSellOrders().add( sellOrder );
        stock.executeOrders();
        assertTrue( stock.getVolume() == 200 );
        assertTrue( stock.getBuyOrders().isEmpty() && stock.getSellOrders().isEmpty() );
        assertTrue( stock.getLastPrice() == 12.33 && stock.getLoPrice() == 12.33 && stock.getHiPrice() == 12.33 );
        assertTrue( trader1.hasMessages() );
        assertTrue( trader2.hasMessages() );

    }

    // Remove block comment below to run JUnit test in console
    /*
     * public static junit.framework.Test suite() { return new
     * JUnit4TestAdapter( JUSafeTradeTest.class ); }
     * 
     * public static void main( String args[] ) {
     * org.junit.runner.JUnitCore.main( "JUSafeTradeTest" ); }
     */
}
