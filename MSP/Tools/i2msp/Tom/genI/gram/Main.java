package gram;
 
import gram.i.iAdaptor;
import gram.i.types.*;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.tree.Tree;
import tom.library.utils.Viewer;
import tom.library.sl.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
	private static boolean tom_equal_term_Strategy(Object t1, Object t2) {return  (t1.equals(t2)) ;}private static boolean tom_is_sort_Strategy(Object t) {return  (t instanceof tom.library.sl.Strategy) ;} private static boolean tom_equal_term_Position(Object t1, Object t2) {return  (t1.equals(t2)) ;}private static boolean tom_is_sort_Position(Object t) {return  (t instanceof tom.library.sl.Position) ;} private static boolean tom_equal_term_int(int t1, int t2) {return  t1==t2 ;}private static boolean tom_is_sort_int(int t) {return  true ;} private static boolean tom_equal_term_char(char t1, char t2) {return  t1==t2 ;}private static boolean tom_is_sort_char(char t) {return  true ;} private static boolean tom_equal_term_String(String t1, String t2) {return  t1.equals(t2) ;}private static boolean tom_is_sort_String(String t) {return  t instanceof String ;} private static  tom.library.sl.Strategy  tom_make_mu( tom.library.sl.Strategy  var,  tom.library.sl.Strategy  v) { return ( new tom.library.sl.Mu(var,v) );}private static  tom.library.sl.Strategy  tom_make_MuVar( String  name) { return ( new tom.library.sl.MuVar(name) );}private static  tom.library.sl.Strategy  tom_make_Identity() { return ( new tom.library.sl.Identity() );}private static  tom.library.sl.Strategy  tom_make_One( tom.library.sl.Strategy  v) { return ( new tom.library.sl.One(v) );}private static  tom.library.sl.Strategy  tom_make_All( tom.library.sl.Strategy  v) { return ( new tom.library.sl.All(v) );}private static  tom.library.sl.Strategy  tom_make_Fail() { return ( new tom.library.sl.Fail() );}private static boolean tom_is_fun_sym_Sequence( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.Sequence );}private static  tom.library.sl.Strategy  tom_empty_list_Sequence() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_Sequence( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.Sequence.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.THEN) );}private static boolean tom_is_empty_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( t == null );}   private static   tom.library.sl.Strategy  tom_append_list_Sequence( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 == null )) {       return l2;     } else if(( l2 == null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.Sequence )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ) == null )) {         return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),l2) ;       } else {         return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),tom_append_list_Sequence(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.Sequence.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_Sequence( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_Sequence())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.Sequence.make(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Sequence(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.THEN) ):tom_empty_list_Sequence()),end,tail)) ;   }   private static boolean tom_is_fun_sym_Choice( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.Choice );}private static  tom.library.sl.Strategy  tom_empty_list_Choice() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_Choice( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.Choice.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_Choice_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_Choice_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.THEN) );}private static boolean tom_is_empty_Choice_Strategy( tom.library.sl.Strategy  t) {return ( t ==null );}   private static   tom.library.sl.Strategy  tom_append_list_Choice( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 ==null )) {       return l2;     } else if(( l2 ==null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.Choice )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ) ==null )) {         return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),l2) ;       } else {         return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),tom_append_list_Choice(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.Choice.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_Choice( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_Choice())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.Choice.make(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Choice(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.THEN) ):tom_empty_list_Choice()),end,tail)) ;   }   private static boolean tom_is_fun_sym_SequenceId( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.SequenceId );}private static  tom.library.sl.Strategy  tom_empty_list_SequenceId() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_SequenceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.SequenceId.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.THEN) );}private static boolean tom_is_empty_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( t == null );}   private static   tom.library.sl.Strategy  tom_append_list_SequenceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 == null )) {       return l2;     } else if(( l2 == null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.SequenceId )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ) == null )) {         return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),l2) ;       } else {         return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),tom_append_list_SequenceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.SequenceId.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_SequenceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_SequenceId())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.SequenceId.make(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_SequenceId(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.THEN) ):tom_empty_list_SequenceId()),end,tail)) ;   }   private static boolean tom_is_fun_sym_ChoiceId( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.ChoiceId );}private static  tom.library.sl.Strategy  tom_empty_list_ChoiceId() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_ChoiceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.ChoiceId.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.THEN) );}private static boolean tom_is_empty_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( t ==null );}   private static   tom.library.sl.Strategy  tom_append_list_ChoiceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 ==null )) {       return l2;     } else if(( l2 ==null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.ChoiceId )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ) ==null )) {         return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),l2) ;       } else {         return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),tom_append_list_ChoiceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.ChoiceId.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_ChoiceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_ChoiceId())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.ChoiceId.make(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_ChoiceId(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.THEN) ):tom_empty_list_ChoiceId()),end,tail)) ;   }   private static  tom.library.sl.Strategy  tom_make_OneId( tom.library.sl.Strategy  v) { return ( new tom.library.sl.OneId(v) );}   private static  tom.library.sl.Strategy  tom_make_AllSeq( tom.library.sl.Strategy  s) { return ( new tom.library.sl.AllSeq(s) );}private static  tom.library.sl.Strategy  tom_make_AUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { return ( tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_cons_list_Sequence(tom_make_One(tom_make_Identity()),tom_empty_list_Sequence())),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_EUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { return ( tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_One(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_empty_list_Choice()))));} private static  tom.library.sl.Strategy  tom_make_Try( tom.library.sl.Strategy  s) { return ( tom_cons_list_Choice(s,tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice())) );}private static  tom.library.sl.Strategy  tom_make_Repeat( tom.library.sl.Strategy  s) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(tom_cons_list_Sequence(s,tom_cons_list_Sequence(tom_make_MuVar("_x"),tom_empty_list_Sequence())),tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_TopDown( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Sequence(v,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("_x")),tom_empty_list_Sequence()))) );}private static  tom.library.sl.Strategy  tom_make_OnceTopDown( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(v,tom_cons_list_Choice(tom_make_One(tom_make_MuVar("_x")),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_RepeatId( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_SequenceId(v,tom_cons_list_SequenceId(tom_make_MuVar("_x"),tom_empty_list_SequenceId()))) );}private static  tom.library.sl.Strategy  tom_make_OnceTopDownId( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_ChoiceId(v,tom_cons_list_ChoiceId(tom_make_OneId(tom_make_MuVar("_x")),tom_empty_list_ChoiceId()))) );}   private static boolean tom_equal_term_DefTipo(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_DefTipo(Object t) {return  (t instanceof gram.i.types.DefTipo) ;}private static boolean tom_equal_term_OpNum(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpNum(Object t) {return  (t instanceof gram.i.types.OpNum) ;}private static boolean tom_equal_term_LComentarios(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_LComentarios(Object t) {return  (t instanceof gram.i.types.LComentarios) ;}private static boolean tom_equal_term_OpComp(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpComp(Object t) {return  (t instanceof gram.i.types.OpComp) ;}private static boolean tom_equal_term_Expressao(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Expressao(Object t) {return  (t instanceof gram.i.types.Expressao) ;}private static boolean tom_equal_term_OpAtribuicao(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpAtribuicao(Object t) {return  (t instanceof gram.i.types.OpAtribuicao) ;}private static boolean tom_equal_term_OpInc(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_OpInc(Object t) {return  (t instanceof gram.i.types.OpInc) ;}private static boolean tom_equal_term_Parametros(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Parametros(Object t) {return  (t instanceof gram.i.types.Parametros) ;}private static boolean tom_equal_term_Argumentos(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Argumentos(Object t) {return  (t instanceof gram.i.types.Argumentos) ;}private static boolean tom_equal_term_Declaracoes(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Declaracoes(Object t) {return  (t instanceof gram.i.types.Declaracoes) ;}private static boolean tom_equal_term_Instrucao(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Instrucao(Object t) {return  (t instanceof gram.i.types.Instrucao) ;}private static boolean tom_equal_term_IntWrapper(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_IntWrapper(Object t) {return  (t instanceof gram.i.types.IntWrapper) ;}private static boolean tom_is_fun_sym_DInt( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DInt) ;}private static boolean tom_is_fun_sym_DChar( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DChar) ;}private static boolean tom_is_fun_sym_DBoolean( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DBoolean) ;}private static boolean tom_is_fun_sym_DFloat( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DFloat) ;}private static boolean tom_is_fun_sym_DVoid( gram.i.types.DefTipo  t) {return  (t instanceof gram.i.types.deftipo.DVoid) ;}private static boolean tom_is_fun_sym_Comentario( gram.i.types.LComentarios  t) {return  (t instanceof gram.i.types.lcomentarios.Comentario) ;}private static  String  tom_get_slot_Comentario_comentario( gram.i.types.LComentarios  t) {return  t.getcomentario() ;}private static boolean tom_is_fun_sym_Id( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Id) ;}private static  String  tom_get_slot_Id_Id( gram.i.types.Expressao  t) {return  t.getId() ;}private static boolean tom_is_fun_sym_Call( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Call) ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  String  tom_get_slot_Call_Id( gram.i.types.Expressao  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c3( gram.i.types.Expressao  t) {return  t.getc3() ;}private static  gram.i.types.Parametros  tom_get_slot_Call_Parametros( gram.i.types.Expressao  t) {return  t.getParametros() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c4( gram.i.types.Expressao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_Call_c5( gram.i.types.Expressao  t) {return  t.getc5() ;}private static boolean tom_is_fun_sym_Int( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Int) ;}private static  int  tom_get_slot_Int_Int( gram.i.types.Expressao  t) {return  t.getInt() ;}private static boolean tom_is_fun_sym_Char( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Char) ;}private static  String  tom_get_slot_Char_Char( gram.i.types.Expressao  t) {return  t.getChar() ;}private static boolean tom_is_fun_sym_True( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.True) ;}private static boolean tom_is_fun_sym_False( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.False) ;}private static boolean tom_is_fun_sym_Float( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Float) ;}private static  int  tom_get_slot_Float_num( gram.i.types.Expressao  t) {return  t.getnum() ;}private static boolean tom_is_fun_sym_Input( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Input) ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c3( gram.i.types.Expressao  t) {return  t.getc3() ;}private static  gram.i.types.DefTipo  tom_get_slot_Input_Tipo( gram.i.types.Expressao  t) {return  t.getTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c4( gram.i.types.Expressao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_Input_c5( gram.i.types.Expressao  t) {return  t.getc5() ;}private static boolean tom_is_fun_sym_Print( gram.i.types.Expressao  t) {return  (t instanceof gram.i.types.expressao.Print) ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c1( gram.i.types.Expressao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c2( gram.i.types.Expressao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c3( gram.i.types.Expressao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_Print_Expressao( gram.i.types.Expressao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c4( gram.i.types.Expressao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_Print_c5( gram.i.types.Expressao  t) {return  t.getc5() ;}private static  gram.i.types.Expressao  tom_make_Empty() { return  gram.i.types.expressao.Empty.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Atrib() { return  gram.i.types.opatribuicao.Atrib.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Mult() { return  gram.i.types.opatribuicao.Mult.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Div() { return  gram.i.types.opatribuicao.Div.make() ;}private static  gram.i.types.OpAtribuicao  tom_make_Soma() { return  gram.i.types.opatribuicao.Soma.make() ;}private static boolean tom_is_fun_sym_Argumento( gram.i.types.Argumentos  t) {return  (t instanceof gram.i.types.argumentos.Argumento) ;}private static  gram.i.types.LComentarios  tom_get_slot_Argumento_c1( gram.i.types.Argumentos  t) {return  t.getc1() ;}private static  gram.i.types.DefTipo  tom_get_slot_Argumento_DefTipo( gram.i.types.Argumentos  t) {return  t.getDefTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Argumento_c2( gram.i.types.Argumentos  t) {return  t.getc2() ;}private static  String  tom_get_slot_Argumento_Id( gram.i.types.Argumentos  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Argumento_c3( gram.i.types.Argumentos  t) {return  t.getc3() ;}private static boolean tom_is_fun_sym_Decl( gram.i.types.Declaracoes  t) {return  (t instanceof gram.i.types.declaracoes.Decl) ;}private static  String  tom_get_slot_Decl_Id( gram.i.types.Declaracoes  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Decl_c1( gram.i.types.Declaracoes  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Decl_c2( gram.i.types.Declaracoes  t) {return  t.getc2() ;}private static  gram.i.types.Expressao  tom_get_slot_Decl_Expressao( gram.i.types.Declaracoes  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Decl_c3( gram.i.types.Declaracoes  t) {return  t.getc3() ;}private static boolean tom_is_fun_sym_Atribuicao( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Atribuicao) ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  String  tom_get_slot_Atribuicao_Id( gram.i.types.Instrucao  t) {return  t.getId() ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.OpAtribuicao  tom_get_slot_Atribuicao_op( gram.i.types.Instrucao  t) {return  t.getop() ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_Atribuicao_Expressao( gram.i.types.Instrucao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Atribuicao_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static boolean tom_is_fun_sym_Declaracao( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Declaracao) ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.DefTipo  tom_get_slot_Declaracao_DefTipo( gram.i.types.Instrucao  t) {return  t.getDefTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.Declaracoes  tom_get_slot_Declaracao_Declaracoes( gram.i.types.Instrucao  t) {return  t.getDeclaracoes() ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.LComentarios  tom_get_slot_Declaracao_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static boolean tom_is_fun_sym_If( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.If) ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_If_Condicao( gram.i.types.Instrucao  t) {return  t.getCondicao() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_If_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.Instrucao  tom_get_slot_If_Instrucao1( gram.i.types.Instrucao  t) {return  t.getInstrucao1() ;}private static  gram.i.types.Instrucao  tom_get_slot_If_Instrucao2( gram.i.types.Instrucao  t) {return  t.getInstrucao2() ;}private static boolean tom_is_fun_sym_While( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.While) ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_While_Condicao( gram.i.types.Instrucao  t) {return  t.getCondicao() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.Instrucao  tom_get_slot_While_Instrucao( gram.i.types.Instrucao  t) {return  t.getInstrucao() ;}private static  gram.i.types.LComentarios  tom_get_slot_While_c6( gram.i.types.Instrucao  t) {return  t.getc6() ;}private static boolean tom_is_fun_sym_For( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.For) ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.Instrucao  tom_get_slot_For_Declaracao( gram.i.types.Instrucao  t) {return  t.getDeclaracao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.Expressao  tom_get_slot_For_Condicao( gram.i.types.Instrucao  t) {return  t.getCondicao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.Expressao  tom_get_slot_For_Expressao( gram.i.types.Instrucao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c6( gram.i.types.Instrucao  t) {return  t.getc6() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c7( gram.i.types.Instrucao  t) {return  t.getc7() ;}private static  gram.i.types.Instrucao  tom_get_slot_For_Instrucao( gram.i.types.Instrucao  t) {return  t.getInstrucao() ;}private static  gram.i.types.LComentarios  tom_get_slot_For_c8( gram.i.types.Instrucao  t) {return  t.getc8() ;}private static boolean tom_is_fun_sym_Return( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Return) ;}private static  gram.i.types.LComentarios  tom_get_slot_Return_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.LComentarios  tom_get_slot_Return_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  gram.i.types.Expressao  tom_get_slot_Return_Expressao( gram.i.types.Instrucao  t) {return  t.getExpressao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Return_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static boolean tom_is_fun_sym_Funcao( gram.i.types.Instrucao  t) {return  (t instanceof gram.i.types.instrucao.Funcao) ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c1( gram.i.types.Instrucao  t) {return  t.getc1() ;}private static  gram.i.types.DefTipo  tom_get_slot_Funcao_DefTipo( gram.i.types.Instrucao  t) {return  t.getDefTipo() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c2( gram.i.types.Instrucao  t) {return  t.getc2() ;}private static  String  tom_get_slot_Funcao_Nome( gram.i.types.Instrucao  t) {return  t.getNome() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c3( gram.i.types.Instrucao  t) {return  t.getc3() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c4( gram.i.types.Instrucao  t) {return  t.getc4() ;}private static  gram.i.types.Argumentos  tom_get_slot_Funcao_Argumentos( gram.i.types.Instrucao  t) {return  t.getArgumentos() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c5( gram.i.types.Instrucao  t) {return  t.getc5() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c6( gram.i.types.Instrucao  t) {return  t.getc6() ;}private static  gram.i.types.Instrucao  tom_get_slot_Funcao_Instrucao( gram.i.types.Instrucao  t) {return  t.getInstrucao() ;}private static  gram.i.types.LComentarios  tom_get_slot_Funcao_c7( gram.i.types.Instrucao  t) {return  t.getc7() ;}private static boolean tom_is_fun_sym_ListaArgumentos( gram.i.types.Argumentos  t) {return  ((t instanceof gram.i.types.argumentos.ConsListaArgumentos) || (t instanceof gram.i.types.argumentos.EmptyListaArgumentos)) ;}private static  gram.i.types.Argumentos  tom_empty_list_ListaArgumentos() { return  gram.i.types.argumentos.EmptyListaArgumentos.make() ;}private static  gram.i.types.Argumentos  tom_cons_list_ListaArgumentos( gram.i.types.Argumentos  e,  gram.i.types.Argumentos  l) { return  gram.i.types.argumentos.ConsListaArgumentos.make(e,l) ;}private static  gram.i.types.Argumentos  tom_get_head_ListaArgumentos_Argumentos( gram.i.types.Argumentos  l) {return  l.getHeadListaArgumentos() ;}private static  gram.i.types.Argumentos  tom_get_tail_ListaArgumentos_Argumentos( gram.i.types.Argumentos  l) {return  l.getTailListaArgumentos() ;}private static boolean tom_is_empty_ListaArgumentos_Argumentos( gram.i.types.Argumentos  l) {return  l.isEmptyListaArgumentos() ;}   private static   gram.i.types.Argumentos  tom_append_list_ListaArgumentos( gram.i.types.Argumentos  l1,  gram.i.types.Argumentos  l2) {     if( l1.isEmptyListaArgumentos() ) {       return l2;     } else if( l2.isEmptyListaArgumentos() ) {       return l1;     } else if( ((l1 instanceof gram.i.types.argumentos.ConsListaArgumentos) || (l1 instanceof gram.i.types.argumentos.EmptyListaArgumentos)) ) {       if(  l1.getTailListaArgumentos() .isEmptyListaArgumentos() ) {         return  gram.i.types.argumentos.ConsListaArgumentos.make( l1.getHeadListaArgumentos() ,l2) ;       } else {         return  gram.i.types.argumentos.ConsListaArgumentos.make( l1.getHeadListaArgumentos() ,tom_append_list_ListaArgumentos( l1.getTailListaArgumentos() ,l2)) ;       }     } else {       return  gram.i.types.argumentos.ConsListaArgumentos.make(l1,l2) ;     }   }   private static   gram.i.types.Argumentos  tom_get_slice_ListaArgumentos( gram.i.types.Argumentos  begin,  gram.i.types.Argumentos  end, gram.i.types.Argumentos  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptyListaArgumentos()  ||  (end==tom_empty_list_ListaArgumentos()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  gram.i.types.argumentos.ConsListaArgumentos.make((( ((begin instanceof gram.i.types.argumentos.ConsListaArgumentos) || (begin instanceof gram.i.types.argumentos.EmptyListaArgumentos)) )? begin.getHeadListaArgumentos() :begin),( gram.i.types.Argumentos )tom_get_slice_ListaArgumentos((( ((begin instanceof gram.i.types.argumentos.ConsListaArgumentos) || (begin instanceof gram.i.types.argumentos.EmptyListaArgumentos)) )? begin.getTailListaArgumentos() :tom_empty_list_ListaArgumentos()),end,tail)) ;   }   private static boolean tom_is_fun_sym_ListaDecl( gram.i.types.Declaracoes  t) {return  ((t instanceof gram.i.types.declaracoes.ConsListaDecl) || (t instanceof gram.i.types.declaracoes.EmptyListaDecl)) ;}private static  gram.i.types.Declaracoes  tom_empty_list_ListaDecl() { return  gram.i.types.declaracoes.EmptyListaDecl.make() ;}private static  gram.i.types.Declaracoes  tom_cons_list_ListaDecl( gram.i.types.Declaracoes  e,  gram.i.types.Declaracoes  l) { return  gram.i.types.declaracoes.ConsListaDecl.make(e,l) ;}private static  gram.i.types.Declaracoes  tom_get_head_ListaDecl_Declaracoes( gram.i.types.Declaracoes  l) {return  l.getHeadListaDecl() ;}private static  gram.i.types.Declaracoes  tom_get_tail_ListaDecl_Declaracoes( gram.i.types.Declaracoes  l) {return  l.getTailListaDecl() ;}private static boolean tom_is_empty_ListaDecl_Declaracoes( gram.i.types.Declaracoes  l) {return  l.isEmptyListaDecl() ;}   private static   gram.i.types.Declaracoes  tom_append_list_ListaDecl( gram.i.types.Declaracoes  l1,  gram.i.types.Declaracoes  l2) {     if( l1.isEmptyListaDecl() ) {       return l2;     } else if( l2.isEmptyListaDecl() ) {       return l1;     } else if( ((l1 instanceof gram.i.types.declaracoes.ConsListaDecl) || (l1 instanceof gram.i.types.declaracoes.EmptyListaDecl)) ) {       if(  l1.getTailListaDecl() .isEmptyListaDecl() ) {         return  gram.i.types.declaracoes.ConsListaDecl.make( l1.getHeadListaDecl() ,l2) ;       } else {         return  gram.i.types.declaracoes.ConsListaDecl.make( l1.getHeadListaDecl() ,tom_append_list_ListaDecl( l1.getTailListaDecl() ,l2)) ;       }     } else {       return  gram.i.types.declaracoes.ConsListaDecl.make(l1,l2) ;     }   }   private static   gram.i.types.Declaracoes  tom_get_slice_ListaDecl( gram.i.types.Declaracoes  begin,  gram.i.types.Declaracoes  end, gram.i.types.Declaracoes  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptyListaDecl()  ||  (end==tom_empty_list_ListaDecl()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  gram.i.types.declaracoes.ConsListaDecl.make((( ((begin instanceof gram.i.types.declaracoes.ConsListaDecl) || (begin instanceof gram.i.types.declaracoes.EmptyListaDecl)) )? begin.getHeadListaDecl() :begin),( gram.i.types.Declaracoes )tom_get_slice_ListaDecl((( ((begin instanceof gram.i.types.declaracoes.ConsListaDecl) || (begin instanceof gram.i.types.declaracoes.EmptyListaDecl)) )? begin.getTailListaDecl() :tom_empty_list_ListaDecl()),end,tail)) ;   }   private static boolean tom_is_fun_sym_SeqInstrucao( gram.i.types.Instrucao  t) {return  ((t instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (t instanceof gram.i.types.instrucao.EmptySeqInstrucao)) ;}private static  gram.i.types.Instrucao  tom_empty_list_SeqInstrucao() { return  gram.i.types.instrucao.EmptySeqInstrucao.make() ;}private static  gram.i.types.Instrucao  tom_cons_list_SeqInstrucao( gram.i.types.Instrucao  e,  gram.i.types.Instrucao  l) { return  gram.i.types.instrucao.ConsSeqInstrucao.make(e,l) ;}private static  gram.i.types.Instrucao  tom_get_head_SeqInstrucao_Instrucao( gram.i.types.Instrucao  l) {return  l.getHeadSeqInstrucao() ;}private static  gram.i.types.Instrucao  tom_get_tail_SeqInstrucao_Instrucao( gram.i.types.Instrucao  l) {return  l.getTailSeqInstrucao() ;}private static boolean tom_is_empty_SeqInstrucao_Instrucao( gram.i.types.Instrucao  l) {return  l.isEmptySeqInstrucao() ;}   private static   gram.i.types.Instrucao  tom_append_list_SeqInstrucao( gram.i.types.Instrucao  l1,  gram.i.types.Instrucao  l2) {     if( l1.isEmptySeqInstrucao() ) {       return l2;     } else if( l2.isEmptySeqInstrucao() ) {       return l1;     } else if( ((l1 instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (l1 instanceof gram.i.types.instrucao.EmptySeqInstrucao)) ) {       if(  l1.getTailSeqInstrucao() .isEmptySeqInstrucao() ) {         return  gram.i.types.instrucao.ConsSeqInstrucao.make( l1.getHeadSeqInstrucao() ,l2) ;       } else {         return  gram.i.types.instrucao.ConsSeqInstrucao.make( l1.getHeadSeqInstrucao() ,tom_append_list_SeqInstrucao( l1.getTailSeqInstrucao() ,l2)) ;       }     } else {       return  gram.i.types.instrucao.ConsSeqInstrucao.make(l1,l2) ;     }   }   private static   gram.i.types.Instrucao  tom_get_slice_SeqInstrucao( gram.i.types.Instrucao  begin,  gram.i.types.Instrucao  end, gram.i.types.Instrucao  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptySeqInstrucao()  ||  (end==tom_empty_list_SeqInstrucao()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  gram.i.types.instrucao.ConsSeqInstrucao.make((( ((begin instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (begin instanceof gram.i.types.instrucao.EmptySeqInstrucao)) )? begin.getHeadSeqInstrucao() :begin),( gram.i.types.Instrucao )tom_get_slice_SeqInstrucao((( ((begin instanceof gram.i.types.instrucao.ConsSeqInstrucao) || (begin instanceof gram.i.types.instrucao.EmptySeqInstrucao)) )? begin.getTailSeqInstrucao() :tom_empty_list_SeqInstrucao()),end,tail)) ;   }    


	static ContaTudo counter;
	static ContaFunc funcao;

	public static void main(String[] args) {
		try {
			iLexer lexer = new iLexer(new ANTLRInputStream(System.in));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			iParser parser = new iParser(tokens);

			Tree b = (Tree) parser.prog().getTree();
			Instrucao p = (Instrucao) iAdaptor.getTerm(b);

			Main main = new Main();

			main.start(p);

			System.out.println(counter.toString());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Main() {
		counter = new ContaTudo();
	}

	private void start(Instrucao p){

		try {
			tom_make_TopDown(tom_make_countFunct()).visit(p);
		} catch(Exception e) {
			System.out.println("the strategy failed");
		}
	}

    public static class countFunct extends tom.library.sl.AbstractStrategyBasic {public countFunct() {super(tom_make_Identity());}public tom.library.sl.Visitable[] getChildren() {tom.library.sl.Visitable[] stratChildren = new tom.library.sl.Visitable[getChildCount()];stratChildren[0] = super.getChildAt(0);return stratChildren;}public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {super.setChildAt(0, children[0]);return this;}public int getChildCount() {return 1;}public tom.library.sl.Visitable getChildAt(int index) {switch (index) {case 0: return super.getChildAt(0);default: throw new IndexOutOfBoundsException();}}public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable child) {switch (index) {case 0: return super.setChildAt(0, child);default: throw new IndexOutOfBoundsException();}}@SuppressWarnings("unchecked")public <T> T visitLight(T v, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (tom_is_sort_LComentarios(v)) {return ((T)visit_LComentarios((( gram.i.types.LComentarios )v),introspector));}if (tom_is_sort_Expressao(v)) {return ((T)visit_Expressao((( gram.i.types.Expressao )v),introspector));}if (tom_is_sort_Instrucao(v)) {return ((T)visit_Instrucao((( gram.i.types.Instrucao )v),introspector));}if (tom_is_sort_DefTipo(v)) {return ((T)visit_DefTipo((( gram.i.types.DefTipo )v),introspector));}if (!(( null  == environment))) {return ((T)any.visit(environment,introspector));} else {return any.visitLight(v,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.DefTipo  _visit_DefTipo( gram.i.types.DefTipo  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.DefTipo )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.Instrucao  _visit_Instrucao( gram.i.types.Instrucao  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.Instrucao )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.Expressao  _visit_Expressao( gram.i.types.Expressao  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.Expressao )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.LComentarios  _visit_LComentarios( gram.i.types.LComentarios  arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {if (!(( null  == environment))) {return (( gram.i.types.LComentarios )any.visit(environment,introspector));} else {return any.visitLight(arg,introspector);}}@SuppressWarnings("unchecked")public  gram.i.types.DefTipo  visit_DefTipo( gram.i.types.DefTipo  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DInt((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {











































































































































				counter.adicionaOperador("Int");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DChar((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				counter.adicionaOperador("Char");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DBoolean((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				counter.adicionaOperador("Boolean");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DFloat((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				counter.adicionaOperador("Float");
			}}}}{if (tom_is_sort_DefTipo(tom__arg)) {if (tom_is_sort_DefTipo((( gram.i.types.DefTipo )tom__arg))) {if (tom_is_fun_sym_DVoid((( gram.i.types.DefTipo )(( gram.i.types.DefTipo )tom__arg)))) {


				counter.adicionaOperador("Void");
			}}}}}return _visit_DefTipo(tom__arg,introspector);}@SuppressWarnings("unchecked")public  gram.i.types.LComentarios  visit_LComentarios( gram.i.types.LComentarios  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_LComentarios(tom__arg)) {if (tom_is_sort_LComentarios((( gram.i.types.LComentarios )tom__arg))) {if (tom_is_fun_sym_Comentario((( gram.i.types.LComentarios )(( gram.i.types.LComentarios )tom__arg)))) {     funcao.incComentarios();    }}}}}return _visit_LComentarios(tom__arg,introspector);}@SuppressWarnings("unchecked")public  gram.i.types.Expressao  visit_Expressao( gram.i.types.Expressao  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Id((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     counter.adicionaOperando(tom_get_slot_Id_Id((( gram.i.types.Expressao )tom__arg)));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Call((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     funcao.incLines(1);     counter.adicionaOperador(";");     counter.adicionaOperador(tom_get_slot_Call_Id((( gram.i.types.Expressao )tom__arg)));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Input((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     funcao.incLines(1);     counter.adicionaOperador(";");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Print((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     funcao.incLines(1);     counter.adicionaOperador(";");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Int((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     counter.adicionaOperando(Integer.toString(tom_get_slot_Int_Int((( gram.i.types.Expressao )tom__arg))));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Char((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     counter.adicionaOperando(tom_get_slot_Char_Char((( gram.i.types.Expressao )tom__arg)));    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_True((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     counter.adicionaOperando("True");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_False((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     counter.adicionaOperando("False");    }}}}{if (tom_is_sort_Expressao(tom__arg)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )tom__arg))) {if (tom_is_fun_sym_Float((( gram.i.types.Expressao )(( gram.i.types.Expressao )tom__arg)))) {     counter.adicionaOperando(Float.toString(tom_get_slot_Float_num((( gram.i.types.Expressao )tom__arg))));    }}}}}return _visit_Expressao(tom__arg,introspector);}@SuppressWarnings("unchecked")public  gram.i.types.Instrucao  visit_Instrucao( gram.i.types.Instrucao  tom__arg, tom.library.sl.Introspector introspector) throws tom.library.sl.VisitFailure {{{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Funcao((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) { String  tom_nome=tom_get_slot_Funcao_Nome((( gram.i.types.Instrucao )tom__arg));      int nArgs = contaArgumentos(tom_get_slot_Funcao_Argumentos((( gram.i.types.Instrucao )tom__arg)));      for(int i=0; i<nArgs-1; i++){      counter.adicionaOperador(",");     }          funcao = new ContaFunc(tom_nome, nArgs);      counter.adicionaOperador(tom_nome);     counter.adicionaOperador("(");     counter.adicionaOperador(")");     counter.adicionaOperador("{");     counter.adicionaOperador("}");     counter.addFunc(funcao);      funcao.incLines(1);    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Declaracao((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {      resolveDecls(tom_get_slot_Declaracao_Declaracoes((( gram.i.types.Instrucao )tom__arg)));      funcao.incLines(1);     counter.adicionaOperador(";");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Atribuicao((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) { gram.i.types.OpAtribuicao  tom_op=tom_get_slot_Atribuicao_op((( gram.i.types.Instrucao )tom__arg));      if(tom_op== tom_make_Atrib()){      counter.adicionaOperador("=");     }     else if(tom_op== tom_make_Mult()){      counter.adicionaOperador("*=");     }     else if(tom_op== tom_make_Div()){      counter.adicionaOperador("/=");     }     else if(tom_op== tom_make_Soma()){      counter.adicionaOperador("+=");     }     else{      counter.adicionaOperador("-=");     }      funcao.incLines(1);     counter.adicionaOperador(";");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_Return((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     funcao.incLines(1);     counter.adicionaOperador(";");     counter.adicionaOperador("Return");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_If((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     funcao.incLines(3);     funcao.incIfs();      if(tom_get_slot_If_Instrucao2((( gram.i.types.Instrucao )tom__arg))!= tom_empty_list_SeqInstrucao()){      counter.adicionaOperador("Else");     }      counter.adicionaOperador("If");     counter.adicionaOperador(")");     counter.adicionaOperador("(");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_While((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     funcao.incLines(1);     funcao.incWhiles();     counter.adicionaOperador("While");     counter.adicionaOperador(")");     counter.adicionaOperador("(");    }}}}{if (tom_is_sort_Instrucao(tom__arg)) {if (tom_is_sort_Instrucao((( gram.i.types.Instrucao )tom__arg))) {if (tom_is_fun_sym_For((( gram.i.types.Instrucao )(( gram.i.types.Instrucao )tom__arg)))) {     funcao.incLines(1);     funcao.incFors();     counter.adicionaOperador("For");     counter.adicionaOperador(")");     counter.adicionaOperador("(");    }}}}}return _visit_Instrucao(tom__arg,introspector);}}private static  tom.library.sl.Strategy  tom_make_countFunct() { return new countFunct();}



	private static int contaArgumentos(Argumentos args){
		{{if (tom_is_sort_Argumentos(args)) {if (tom_is_fun_sym_ListaArgumentos((( gram.i.types.Argumentos )(( gram.i.types.Argumentos )args)))) {if (!( ( tom_is_empty_ListaArgumentos_Argumentos((( gram.i.types.Argumentos )args)) || tom_equal_term_Argumentos((( gram.i.types.Argumentos )args), tom_empty_list_ListaArgumentos()) ) )) {

				return contaArgumentos(((tom_is_fun_sym_ListaArgumentos((( gram.i.types.Argumentos )args)))?(tom_get_head_ListaArgumentos_Argumentos((( gram.i.types.Argumentos )args))):((( gram.i.types.Argumentos )args)))) + contaArgumentos(((tom_is_fun_sym_ListaArgumentos((( gram.i.types.Argumentos )args)))?(tom_get_tail_ListaArgumentos_Argumentos((( gram.i.types.Argumentos )args))):(tom_empty_list_ListaArgumentos())));
			}}}}{if (tom_is_sort_Argumentos(args)) {if (tom_is_sort_Argumentos((( gram.i.types.Argumentos )args))) {if (tom_is_fun_sym_Argumento((( gram.i.types.Argumentos )(( gram.i.types.Argumentos )args)))) {



				counter.adicionaOperando(tom_get_slot_Argumento_Id((( gram.i.types.Argumentos )args)));

				return 1;
			}}}}}

		return 0;
	}

	private static void resolveDecls(Declaracoes decls){
		{{if (tom_is_sort_Declaracoes(decls)) {if (tom_is_sort_Declaracoes((( gram.i.types.Declaracoes )decls))) {if (tom_is_fun_sym_Decl((( gram.i.types.Declaracoes )(( gram.i.types.Declaracoes )decls)))) { gram.i.types.Expressao  tom_exp=tom_get_slot_Decl_Expressao((( gram.i.types.Declaracoes )decls));

				counter.adicionaOperando(tom_get_slot_Decl_Id((( gram.i.types.Declaracoes )decls)));

				if(tom_exp!= tom_make_Empty()){
					counter.adicionaOperador("=");
				}

				resolveExpr(tom_exp);
			}}}}{if (tom_is_sort_Declaracoes(decls)) {if (tom_is_fun_sym_ListaDecl((( gram.i.types.Declaracoes )(( gram.i.types.Declaracoes )decls)))) {if (!( ( tom_is_empty_ListaDecl_Declaracoes((( gram.i.types.Declaracoes )decls)) || tom_equal_term_Declaracoes((( gram.i.types.Declaracoes )decls), tom_empty_list_ListaDecl()) ) )) {

				resolveDecls(((tom_is_fun_sym_ListaDecl((( gram.i.types.Declaracoes )decls)))?(tom_get_head_ListaDecl_Declaracoes((( gram.i.types.Declaracoes )decls))):((( gram.i.types.Declaracoes )decls))));
				resolveDecls(((tom_is_fun_sym_ListaDecl((( gram.i.types.Declaracoes )decls)))?(tom_get_tail_ListaDecl_Declaracoes((( gram.i.types.Declaracoes )decls))):(tom_empty_list_ListaDecl())));
			}}}}}

	}

	private static void resolveExpr(Expressao exp){
		{{if (tom_is_sort_Expressao(exp)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )exp))) {if (tom_is_fun_sym_Id((( gram.i.types.Expressao )(( gram.i.types.Expressao )exp)))) {

				counter.adicionaOperando(tom_get_slot_Id_Id((( gram.i.types.Expressao )exp)));
			}}}}{if (tom_is_sort_Expressao(exp)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )exp))) {if (tom_is_fun_sym_Input((( gram.i.types.Expressao )(( gram.i.types.Expressao )exp)))) {


				counter.adicionaOperador("Input");
			}}}}{if (tom_is_sort_Expressao(exp)) {if (tom_is_sort_Expressao((( gram.i.types.Expressao )exp))) {if (tom_is_fun_sym_Print((( gram.i.types.Expressao )(( gram.i.types.Expressao )exp)))) {


				counter.adicionaOperador("Print");
			}}}}}

	}

}

class ContaFunc{

	private String nome;
	private int nLinhas, nArgs, nIfs, nWhiles, nFors, nComentarios;	

	public ContaFunc(String nome, int nArgs){
		this.nome = nome;
		this.nLinhas = 0;
		this.nArgs = nArgs;
		this.nIfs = 0;
		this.nWhiles = 0;
		this.nFors = 0;
		this.nComentarios = 0;
	}

	public String getNome(){
		return this.nome;
	}

	public int getLines(){
		return this.nLinhas;
	}

	public void incLines(int n){
		this.nLinhas += n;
	}

	public void incIfs(){
		this.nIfs++;
	}

	public void incWhiles(){
		this.nWhiles++;
	}

	public void incFors(){
		this.nFors++;
	}

	public void incComentarios(){
		this.nComentarios++;
	}

	public String toString(){

		StringBuilder sb = new StringBuilder();

		sb.append("----------------------------------------\n");
		sb.append(this.nome + "\n\tNúmero de argumentos: " + this.nArgs + "\n");
		sb.append("\tNúmero de linhas: " + this.nLinhas + "\n");
		sb.append("\tNúmero de ifs: " + this.nIfs + "\n");
		sb.append("\tNúmero de whiles: " + this.nWhiles + "\n");
		sb.append("\tNúmero de fors: " + this.nFors + "\n");
		sb.append("\tNúmero de comentários: " + this.nComentarios + "\n");

		return sb.toString();
	}
}

class ContaTudo{

	private int lines;
	private HashMap<String, ContaFunc> funcs;
	private HashMap<String, Integer> operandos, operadores;

	public ContaTudo(){
		this.funcs = new HashMap<>();
		operandos = new HashMap<>();
		operadores = new HashMap<>();
	}

	public void addFunc(ContaFunc func){
		this.funcs.put(func.getNome(), func);
	}

	public int totLinhas(){
		int res = 0;

		for(Map.Entry<String, ContaFunc> entry : this.funcs.entrySet()){
			res += entry.getValue().getLines();
		}

		return res;
	}

	public void adicionaOperando(String op){
		if(this.operandos.containsKey(op)){
			int n = this.operandos.get(op);
			this.operandos.put(op, n+1);
		}
		else{
			this.operandos.put(op, 1);
		}
	}

	public void adicionaOperador(String op){
		if(this.operadores.containsKey(op)){
			int n = this.operadores.get(op);
			this.operadores.put(op, n+1);
		}
		else{
			this.operadores.put(op, 1);
		}
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append("Número total de linhas: " + this.totLinhas() + "\n");
		sb.append("Número total de funções: " + this.funcs.size() + "\n");

		for(Map.Entry<String, ContaFunc> entry : this.funcs.entrySet()){
			sb.append(entry.getValue().toString());
		}

		sb.append("----OPERADORES-----\n");
		sb.append(this.operadores.toString());
		sb.append("\n----OPERANDOS-----\n");
		sb.append(this.operandos.toString());

		return sb.toString();
	}
}