/**
 * Created by ellie on 6/27/2017.
 */
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.util.ArrayList;

public class ParseTreeVisitor extends DMLBaseVisitor<QueryPlan>{

    //////////////////////////////////////////////////////////////////////
    //                       COMMAND VISITORS                           //
    //////////////////////////////////////////////////////////////////////
    
    // open-cmd ::= OPEN relation-name
    @Override public QueryPlan visitOpencmd(DMLParser.OpencmdContext ctx){
        System.out.println("In visitOpencmd()");

        OpenCmd oc = new OpenCmd();
        System.out.println("Open command table: " + ctx.relname().getText());
        oc.setTableName(ctx.relname().getText());

        return oc;
    }

    // close-cmd ::= CLOSE relation-name
    @Override public QueryPlan visitClosecmd(DMLParser.ClosecmdContext ctx){
        System.out.println("In visitClosecmd()");

        CloseCmd cc = new CloseCmd();
        System.out.println("Close command table: " + ctx.relname().getText());
        cc.setTableName(ctx.relname().getText());

        return cc;
    }

    // write-cmd ::= WRITE relation-name
    @Override public QueryPlan visitWritecmd(DMLParser.WritecmdContext ctx){
        System.out.println("In visitWritecmd()");

        WriteCmd wc = new WriteCmd();
        System.out.println("Close command table: " + ctx.relname().getText());
        wc.setTableName(ctx.relname().getText());

        return wc;
    }

    // exit-cmd ::= EXIT
    @Override public QueryPlan visitExitcmd(DMLParser.ExitcmdContext ctx){
        System.out.println("In visitExitcmd()");

        ExitCmd ec = new ExitCmd();

        return ec;
    }

    // show-cmd ::= SHOW atomic-expr
    @Override public QueryPlan visitShowcmd(DMLParser.ShowcmdContext ctx){
        System.out.println("In visitShowcmd()");

        ShowCmd sc = new ShowCmd();
        System.out.println("Show command atomic expr: " + ctx.atomexpr().getText());
        sc.setAtomExpr(visitAtomexpr(ctx.atomexpr()));

        return sc;
    }
    
    //TODO create-cmd
    
    //TODO update-cmd
    
    //TODO insert-cmd
    
    //TODO delete-cmd

    //////////////////////////////////////////////////////////////////////
    //                         QUERY VISITORS                           //
    //////////////////////////////////////////////////////////////////////

    // query ::= relation-name <- expr
    @Override public QueryPlan visitQuery(DMLParser.QueryContext ctx){
        System.out.println("In visitQuery()");

        QueryVisitor qv = new QueryVisitor();

        // name of query table is stored as relname in grammar
        qv.setTableName(ctx.relname().getText());


        System.out.println("Query relation name context: " + ctx.relname().getText());
        System.out.println("Query expr context: " + ctx.expr().getText());

        // store the components of the expression
        DMLParser.ExprContext expr_ctx = ctx.expr();
        if(expr_ctx != null) {
            qv.setExpr(visitExpr(expr_ctx));
        }

        return qv;
    }

    //TODO complete condition visiting hierarchy
    // selection ::= select ( condition ) atomic-expr
    @Override public QueryPlan visitSelection(DMLParser.SelectionContext ctx){
        System.out.println("In visitSelection()");

        SelectionQuery sq = new SelectionQuery();

        // set condition in infix form in arraylist
        if(ctx.condition() != null){
            System.out.println(ctx.condition().getText());
            sq.addCondition(visitCondition(ctx.condition()));
        }
        for(int i=0; i<ctx.condition().conjunction().size(); ++i){
            if(ctx.condition().conjunction(i) != null){
                System.out.println("Selection condition at " + Integer.toString(i) + " " + ctx.condition().getText());
                //sq.addCondition(visitCondition(visitCondition(ctx.condition().conjunction(i))));
            }
        }

        if (ctx.atomexpr() != null) {
            sq.setAtomicQuery(visitAtomexpr(ctx.atomexpr()));
        }

        return sq;
    }

    // condition ::= conjunction { || conjunction }
    @Override public QueryPlan visitCondition(DMLParser.ConditionContext ctx) {
        System.out.println("In visitCondition()");
        ConditionQuery co = new ConditionQuery();

        for(int i=0; i<ctx.conjunction().size(); ++i){
            System.out.println("Condition conjunction at " + Integer.toString(i) + " " + ctx.conjunction(i).comparison(i).getText());
        }
       // System.out.println("Condition conjunction 1: " + ctx.conjunction(0).getText());
        //System.out.println("Condition conjunction 2: " + ctx.conjunction(1).getText());

        return co;
    }

    // conjunction ::= comparison { && comparison } 
    @Override public QueryPlan visitConjunction(DMLParser.ConjunctionContext ctx) {
        System.out.println("In visitCondition");

        QueryPlan cj = new QueryPlan();

        return cj;

    }

    // atomic-expr ::= relation-name | (expr)
    @Override public QueryPlan visitAtomexpr(DMLParser.AtomexprContext ctx){
        System.out.println("In visitAtomexpr()");

        AtomicQuery aq = new AtomicQuery();

        if(ctx.relname() != null) {
            aq.setRelationName(ctx.relname().getText());
            System.out.println("AtomicExpr Relation Name: " + ctx.relname().getText());
        }
        if(ctx.expr() != null){
            System.out.println("AtomicExpr Expr: " + ctx.expr().getText());
            if(ctx.expr() != null) {
                aq.setExpr(visitExpr(ctx.expr()));
            }
        }

        return aq;
    }

    // project ( attribute-list ) atomic-expr
    @Override public QueryPlan visitProjection(DMLParser.ProjectionContext ctx) {
        System.out.println("In visitProjection()");

        ProjectionQuery pq = new ProjectionQuery();

        for(int i=0; i<ctx.attrlist().attrname().size(); ++i){
            if(ctx.attrlist().attrname(i) != null){
                System.out.println("Projection attribute list context at " + Integer.toString(i) + " " + ctx.attrlist().attrname(i).getText());
                pq.addAttribute(ctx.attrlist().attrname(i).getText());
            }
        }

        if(ctx.atomexpr() != null){
            pq.setAtomicQuery(visitAtomexpr(ctx.atomexpr()));
            System.out.println("Projection atomic expr: " + ctx.atomexpr().getText());
        }


        return pq;
    }

    // renaming ::= rename ( attribute-list ) atomic expr
    @Override public QueryPlan visitRenaming(DMLParser.RenamingContext ctx) {
        System.out.println("In visitRenaming()");

        RenamingQuery rq = new RenamingQuery();

        for(int i=0; i<ctx.attrlist().attrname().size(); ++i){
            if(ctx.attrlist().attrname(i) != null){
                System.out.println("Renaming attribute list context at " + Integer.toString(i) + " " + ctx.attrlist().attrname(i).getText());
                rq.addAttribute(ctx.attrlist().attrname(i).getText());
            }
        }

        if(ctx.atomexpr() != null){
            rq.setAtomicQuery(visitAtomexpr(ctx.atomexpr()));
            System.out.println("Renaming atomic expr: " + ctx.atomexpr().getText());
        }

        return rq;
    }

    // union ::= atomic-expr + atomic-expr
    @Override public QueryPlan visitUnion(DMLParser.UnionContext ctx) {
        System.out.println("In visitUnion()");

        UnionQuery uq = new UnionQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Union left atomic expr: " + ctx.atomexpr(0).getText());
            uq.addAtomExpr(visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Union right atomic expr: " + ctx.atomexpr(1).getText());
            uq.addAtomExpr(visitAtomexpr(ctx.atomexpr(1)));
        }

        return uq;

    }

    // difference ::= atomic-expr - atomic-expr
    @Override public QueryPlan visitDifference(DMLParser.DifferenceContext ctx) {
        System.out.println("In visitDifference()");

        DifferenceQuery dq = new DifferenceQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Difference left atomic expr: " + ctx.atomexpr(0).getText());
            dq.addAtomExpr(visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Difference right atomic expr: " + ctx.atomexpr(1).getText());
            dq.addAtomExpr(visitAtomexpr(ctx.atomexpr(1)));
        }

        return dq;
    }

    // product ::= atomic-expr * atomic-expr
    @Override public QueryPlan visitProduct(DMLParser.ProductContext ctx) {
        System.out.println("In visitProduct()");

        ProductQuery pq = new ProductQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Product left atomic expr: " + ctx.atomexpr(0).getText());
            pq.addAtomExpr(visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Product right atomic expr: " + ctx.atomexpr(1).getText());
            pq.addAtomExpr(visitAtomexpr(ctx.atomexpr(1)));
        }

        return pq;
    }

    // natural-join ::= atomic-expr & atomic-expr
    @Override public QueryPlan visitNatjoin(DMLParser.NatjoinContext ctx) {
        System.out.println("In visitNatjoin()");

        NatjoinQuery nq = new NatjoinQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Natural join left atomic expr: " + ctx.atomexpr(0).getText());
            nq.addAtomExpr(visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Natural join right atomic expr: " + ctx.atomexpr(1).getText());
            nq.addAtomExpr(visitAtomexpr(ctx.atomexpr(1)));
        }

        return nq;
    }


}
