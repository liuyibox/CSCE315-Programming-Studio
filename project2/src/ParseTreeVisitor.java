/**
 * Visitor of the Parse Tree, executes instructions upon visiting nodes.
 */
import java.lang.*;

public class ParseTreeVisitor extends DMLBaseVisitor<QueryPlan>{

    //////////////////////////////////////////////////////////////////////
    //                       COMMAND VISITORS                           //
    //////////////////////////////////////////////////////////////////////

    // cmd ::= command ;

    /**
     * Creates a command visitor base upon the type of command visited.
     * @param ctx Context of a command.
     * @return The CommandVisitor QueryPlan.
     */
    @Override public QueryPlan visitCommand(DMLParser.CommandContext ctx){
        System.out.println("In visitCommand");

        CommandVisitor cv = new CommandVisitor();

        if(ctx.opencmd() != null) cv.setCmd(visit(ctx.opencmd()));
        if(ctx.closecmd() != null) cv.setCmd(visit(ctx.closecmd()));
        if(ctx.exitcmd() != null) cv.setCmd(visit(ctx.exitcmd()));
        if(ctx.writecmd() != null) cv.setCmd(visit(ctx.writecmd()));
        if(ctx.showcmd() != null) cv.setCmd(visit(ctx.showcmd()));
        if(ctx.createcmd() != null) cv.setCmd(visit(ctx.createcmd()));
        if(ctx.updatecmd() != null) cv.setCmd(visit(ctx.updatecmd()));
        if(ctx.insertcmd() != null) cv.setCmd(visit(ctx.insertcmd()));
        if(ctx.deletecmd() != null) cv.setCmd(visit(ctx.deletecmd()));

        cv.execute();
        
        return cv;
    }

    // open-cmd ::= OPEN relation-name

    /**
     * Visits the OPEN command.
     * @param ctx the ctx of the visit.
     * @return The OpenCmd Query Plan
     */
    @Override public QueryPlan visitOpencmd(DMLParser.OpencmdContext ctx){
        System.out.println("In visitOpencmd()");

        OpenCmd oc = new OpenCmd();
        System.out.println("Open command table: " + ctx.relname().getText());
        oc.setTableName(ctx.relname().getText());

        return oc;
    }

    // close-cmd ::= CLOSE relation-name

    /**
     * Visits the CLOSE command
     * @param ctx The context of the CLOSE command.
     * @return The CloseCmd QueryPlan
     */
    @Override public QueryPlan visitClosecmd(DMLParser.ClosecmdContext ctx){
        System.out.println("In visitClosecmd()");

        CloseCmd cc = new CloseCmd();
        System.out.println("Close command table: " + ctx.relname().getText());
        cc.setTableName(ctx.relname().getText());

        return cc;
    }

    // write-cmd ::= WRITE relation-name

    /**
     * Visits the WriteCommand.
     * @param ctx The context of the WRITE command.
     * @return The WriteCmd QueryPlan
     */
    @Override public QueryPlan visitWritecmd(DMLParser.WritecmdContext ctx){
        System.out.println("In visitWritecmd()");

        WriteCmd wc = new WriteCmd();
        System.out.println("Close command table: " + ctx.relname().getText());
        wc.setTableName(ctx.relname().getText());

        return wc;
    }

    // exit-cmd ::= EXIT

    /**
     * Visits the EXIT command
     * @param ctx The Exit command context
     * @return The ExitCmd QueryPlan
     */
    @Override public QueryPlan visitExitcmd(DMLParser.ExitcmdContext ctx){
        System.out.println("In visitExitcmd()");

        ExitCmd ec = new ExitCmd();

        return ec;
    }

    // show-cmd ::= SHOW atomic-expr

    /**
     * Visits the SHOW command.
     * @param ctx The SHOW command context.
     * @return The ShowCmd QueryPlan
     */
    @Override public QueryPlan visitShowcmd(DMLParser.ShowcmdContext ctx){
        System.out.println("In visitShowcmd()");

        ShowCmd sc = new ShowCmd();
        System.out.println("Show command atomic expr: " + ctx.atomexpr().getText());
        sc.setAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr()));

        return sc;
    }

    // create-cmd ::= CREATE TABLE relation-name ( typed-attributelist ) PRIMARY KEY ( attribute-list )

    /**
     * Visits the CREATE command.
     * @param ctx The CREATE command context.
     * @return The CreateCmd QueryPlan.
     */
    @Override public QueryPlan visitCreatecmd(DMLParser.CreatecmdContext ctx){
        System.out.println("In visitCreatecmd()");

        CreateCmd cc = new CreateCmd();

        // set table name
        cc.setTableName(ctx.relname().getText());
        
        // adding attributes
        for(int i=0; i<ctx.typedAttributeList().attrname().size(); ++i){
            if(ctx.typedAttributeList().attrname(i) != null){
                System.out.println("Create attribute list context at " + Integer.toString(i) + " " + ctx.typedAttributeList().attrname(i).getText());
                System.out.println("Create attribute list context at " + Integer.toString(i) + " " + ctx.typedAttributeList().type(i).getText());
                cc.addAttribute(ctx.typedAttributeList().attrname(i).getText() + " " + ctx.typedAttributeList().type(i).getText());
            }
        }

        // adding primary keys
        for(int i=0; i<ctx.attrlist().attrname().size(); ++i){
            if(ctx.attrlist().attrname(i) != null){
                System.out.println("Create primary key list context at " + Integer.toString(i) + " " + ctx.attrlist().attrname(i).getText());
                cc.addPrimaryKey(ctx.attrlist().attrname(i).getText());
            }
        }

        return cc;
    }

    //TODO update-cmd
    // update-cmd ::= UPDATE relation-name SET attribute-name = literal { , attribute-name = literal } WHERE condition

    /**
     * Visits the UPDATE command.
     * @param ctx The UPDATE command context.
     * @return The UpdateCmd QueryPlan.
     */
    @Override public QueryPlan visitUpdatecmd(DMLParser.UpdatecmdContext ctx){
        System.out.println("In visitUpdateCmd()");

        UpdateCmd uc = new UpdateCmd();

        // set table name
        uc.setTableName(ctx.relname().getText());

        // adding attributes
        for(int i=0; i<ctx.attrname().size(); ++i){
            if(ctx.attrname(i) != null){
                System.out.println("Update attribute name context at " + Integer.toString(i) + " " + ctx.attrname(i).getText());
                uc.addAttribute(ctx.attrname(i).getText());
            }
        }

        // adding literals
        for(int i=0; i<ctx.literal().size(); ++i){
            if(ctx.literal(i) != null){
                System.out.println("Update literal list context at " + Integer.toString(i) + " " + ctx.literal(i).getText());
                uc.addAttribute(ctx.literal(i).getText());
            }
        }

        // set condition in infix form in array
        uc.setCondition((Condition)visitCondition(ctx.condition()));

        return uc;
    }

    // insert-cmd ::= INSERT INTO relation-name VALUES FROM ( literal { ,  literal } ) | INSERT INTO relation-name VALUES FROM RELATION expr

    /**
     * Visits the INSERT command.
     * @param ctx The context of the INSERT command.
     * @return The InsertCmd QueryPlan
     */
    @Override public QueryPlan visitInsertcmd(DMLParser.InsertcmdContext ctx){
        System.out.println("In visitInsertcmd()");

        InsertCmd cc = new InsertCmd();

        // set table name
        cc.setTableName(ctx.relname().getText());

        // adding primary keys
        for(int i=0; i<ctx.literal().size(); ++i){
            if(ctx.literal(i) != null){
                System.out.println("Insert literal list context at " + Integer.toString(i) + " " + ctx.literal(i).getText());
                cc.addAttribute(ctx.literal(i).getText());
            }
        }

        return cc;
    }

    // delete-cmd ::= DELETE FROM relation-name WHERE condition

    /**
     * Visits the DELETE command.
     * @param ctx The context of the DELETE command.
     * @return The DeleteCmd QueryPlan.
     */
    @Override public QueryPlan visitDeletecmd(DMLParser.DeletecmdContext ctx){
        System.out.println("In visitDeleteCmd()");

        DeleteCmd dc = new DeleteCmd();

        // set table name
        dc.setTableName(ctx.relname().getText());

        // set condition in infix form in array
        dc.setCondition((Condition)visitCondition(ctx.condition()));

        return dc;
    }

    //////////////////////////////////////////////////////////////////////
    //                         QUERY VISITORS                           //
    //////////////////////////////////////////////////////////////////////

    // query ::= relation-name <- expr

    /**
     * Visits a query.
     * @param ctx The context of the query.
     * @return The QueryVisitor QueryPlan.
     */
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

        qv.execute();
        
        return qv;
    }

    // selection ::= select ( condition ) atomic-expr

    /**
     * Visits the selection Query.
     * @param ctx The context of the selection.
     * @return The SelectionQuery QueryPlan.
     */
    @Override public QueryPlan visitSelection(DMLParser.SelectionContext ctx){
        System.out.println("In visitSelection()");

        SelectionQuery sq = new SelectionQuery();

        // set condition in infix form in array
        sq.setCondition((Condition)visitCondition(ctx.condition()));

        if (ctx.atomexpr() != null) {
            sq.setAtomicQuery((AtomicQuery)visitAtomexpr(ctx.atomexpr()));
        }

        return sq;
    }

    // condition ::= conjunction { || conjunction }

    /**
     * Visits the condition context.
     * @param ctx The context of the condition.
     * @return The cond QueryPlan.
     */
    @Override public QueryPlan visitCondition(DMLParser.ConditionContext ctx) {
        System.out.println("In visitCondition()");
        Condition cond = new Condition();
        for(int i=0; i<ctx.conjunction().size(); ++i){
            if(ctx.conjunction(i) != null){
                Conjunction conj = new Conjunction();
                System.out.println("Selection conjunction at " + Integer.toString(i) + " " + ctx.conjunction(i).getText());
                for(int j=0; j<ctx.conjunction(i).comparison().size(); ++j){
                    Comparison comp = new Comparison();
                    System.out.println("Selection comparison at " + Integer.toString(j) + " " + ctx.conjunction(i).comparison(j).getText());
                    if(ctx.conjunction(i).comparison(j).operand(0) != null) {
                        System.out.println("Operand1: " + ctx.conjunction(i).comparison(j).operand(0).getText());
                        System.out.println("Operand2: " + ctx.conjunction(i).comparison(j).operand(1).getText());
                        System.out.println("Operation: " + ctx.conjunction(i).comparison(j).op().getText());

                        comp.setOperand1(ctx.conjunction(i).comparison(j).operand(0).getText());
                        comp.setOperand2(ctx.conjunction(i).comparison(j).operand(1).getText());
                        comp.setOperation(ctx.conjunction(i).comparison(j).op().getText());
                    }
                    else {
                        // it's another condition
                    }

                    conj.compareVec.add(comp);
                }

                cond.conjuncVec.add(conj);

            }
        }
        return cond;
    }

    // atomic-expr ::= relation-name | (expr)

    /**
     * Visits the context of an atomic expression.
     * @param ctx The atomexprContext
     * @return The AtomicQuery QueryPlan
     */
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

    /**
     * Visits the projection context.
     * @param ctx The projection context.
     * @return The ProjectionQuery QueryPlan.
     */
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
            pq.setAtomicQuery((AtomicQuery)visitAtomexpr(ctx.atomexpr()));
            System.out.println("Projection atomic expr: " + ctx.atomexpr().getText());
        }


        return pq;
    }

    // renaming ::= rename ( attribute-list ) atomic expr

    /**
     * Visits the renaming context.
     * @param ctx The renaming context
     * @return The RenamingQuery QueryPlan
     */
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
            rq.setAtomicQuery((AtomicQuery)visitAtomexpr(ctx.atomexpr()));
            System.out.println("Renaming atomic expr: " + ctx.atomexpr().getText());
        }

        return rq;
    }

    // union ::= atomic-expr + atomic-expr

    /**
     * Visits the union context.
     * @param ctx The union context.
     * @return The UnionQuery QueryPlan
     */
    @Override public QueryPlan visitUnion(DMLParser.UnionContext ctx) {
        System.out.println("In visitUnion()");

        UnionQuery uq = new UnionQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Union left atomic expr: " + ctx.atomexpr(0).getText());
            uq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Union right atomic expr: " + ctx.atomexpr(1).getText());
            uq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(1)));
        }

        return uq;

    }

    // difference ::= atomic-expr - atomic-expr

    /**
     * Visits the difference query
     * @param ctx the difference context
     * @return The DifferenceQuery QueryPlan
     */
    @Override public QueryPlan visitDifference(DMLParser.DifferenceContext ctx) {
        System.out.println("In visitDifference()");

        DifferenceQuery dq = new DifferenceQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Difference left atomic expr: " + ctx.atomexpr(0).getText());
            dq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Difference right atomic expr: " + ctx.atomexpr(1).getText());
            dq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(1)));
        }

        return dq;
    }

    // product ::= atomic-expr * atomic-expr

    /**
     * Visits the product query
     * @param ctx The product context
     * @return The ProductQuery QueryPlan.
     */
    @Override public QueryPlan visitProduct(DMLParser.ProductContext ctx) {
        System.out.println("In visitProduct()");

        ProductQuery pq = new ProductQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Product left atomic expr: " + ctx.atomexpr(0).getText());
            pq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Product right atomic expr: " + ctx.atomexpr(1).getText());
            pq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(1)));
        }

        return pq;
    }

    // natural-join ::= atomic-expr & atomic-expr

    /**
     * Visits the natural join query
     * @param ctx The natural join context
     * @return The NatjoinQuery QueryPlan
     */
    @Override public QueryPlan visitNatjoin(DMLParser.NatjoinContext ctx) {
        System.out.println("In visitNatjoin()");

        NatjoinQuery nq = new NatjoinQuery();

        if(ctx.atomexpr(0) != null){
            System.out.println("Natural join left atomic expr: " + ctx.atomexpr(0).getText());
            nq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(0)));
        }
        if(ctx.atomexpr(1) != null){
            System.out.println("Natural join right atomic expr: " + ctx.atomexpr(1).getText());
            nq.addAtomExpr((AtomicQuery)visitAtomexpr(ctx.atomexpr(1)));
        }

        return nq;
    }


}
