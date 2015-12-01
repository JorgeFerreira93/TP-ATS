package maqv;
 
import maqv.msp.mspAdaptor;
import maqv.msp.types.*;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.tree.Tree;
import tom.library.utils.Viewer;
import tom.library.sl.*;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
	private static boolean tom_equal_term_Strategy(Object t1, Object t2) {return  (t1.equals(t2)) ;}private static boolean tom_is_sort_Strategy(Object t) {return  (t instanceof tom.library.sl.Strategy) ;} private static boolean tom_equal_term_Position(Object t1, Object t2) {return  (t1.equals(t2)) ;}private static boolean tom_is_sort_Position(Object t) {return  (t instanceof tom.library.sl.Position) ;} private static boolean tom_equal_term_int(int t1, int t2) {return  t1==t2 ;}private static boolean tom_is_sort_int(int t) {return  true ;} private static boolean tom_equal_term_char(char t1, char t2) {return  t1==t2 ;}private static boolean tom_is_sort_char(char t) {return  true ;} private static boolean tom_equal_term_String(String t1, String t2) {return  t1.equals(t2) ;}private static boolean tom_is_sort_String(String t) {return  t instanceof String ;} private static  tom.library.sl.Strategy  tom_make_mu( tom.library.sl.Strategy  var,  tom.library.sl.Strategy  v) { return ( new tom.library.sl.Mu(var,v) );}private static  tom.library.sl.Strategy  tom_make_MuVar( String  name) { return ( new tom.library.sl.MuVar(name) );}private static  tom.library.sl.Strategy  tom_make_Identity() { return ( new tom.library.sl.Identity() );}private static  tom.library.sl.Strategy  tom_make_One( tom.library.sl.Strategy  v) { return ( new tom.library.sl.One(v) );}private static  tom.library.sl.Strategy  tom_make_All( tom.library.sl.Strategy  v) { return ( new tom.library.sl.All(v) );}private static  tom.library.sl.Strategy  tom_make_Fail() { return ( new tom.library.sl.Fail() );}private static boolean tom_is_fun_sym_Sequence( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.Sequence );}private static  tom.library.sl.Strategy  tom_empty_list_Sequence() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_Sequence( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.Sequence.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.THEN) );}private static boolean tom_is_empty_Sequence_Strategy( tom.library.sl.Strategy  t) {return ( t == null );}   private static   tom.library.sl.Strategy  tom_append_list_Sequence( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 == null )) {       return l2;     } else if(( l2 == null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.Sequence )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ) == null )) {         return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),l2) ;       } else {         return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),tom_append_list_Sequence(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.Sequence.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_Sequence( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_Sequence())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.Sequence.make(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Sequence(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.THEN) ):tom_empty_list_Sequence()),end,tail)) ;   }   private static boolean tom_is_fun_sym_Choice( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.Choice );}private static  tom.library.sl.Strategy  tom_empty_list_Choice() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_Choice( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.Choice.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_Choice_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_Choice_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.THEN) );}private static boolean tom_is_empty_Choice_Strategy( tom.library.sl.Strategy  t) {return ( t ==null );}   private static   tom.library.sl.Strategy  tom_append_list_Choice( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 ==null )) {       return l2;     } else if(( l2 ==null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.Choice )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ) ==null )) {         return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),l2) ;       } else {         return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),tom_append_list_Choice(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.Choice.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_Choice( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_Choice())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.Choice.make(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Choice(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.THEN) ):tom_empty_list_Choice()),end,tail)) ;   }   private static boolean tom_is_fun_sym_SequenceId( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.SequenceId );}private static  tom.library.sl.Strategy  tom_empty_list_SequenceId() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_SequenceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.SequenceId.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.THEN) );}private static boolean tom_is_empty_SequenceId_Strategy( tom.library.sl.Strategy  t) {return ( t == null );}   private static   tom.library.sl.Strategy  tom_append_list_SequenceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 == null )) {       return l2;     } else if(( l2 == null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.SequenceId )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ) == null )) {         return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),l2) ;       } else {         return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),tom_append_list_SequenceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.SequenceId.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_SequenceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_SequenceId())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.SequenceId.make(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_SequenceId(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.THEN) ):tom_empty_list_SequenceId()),end,tail)) ;   }   private static boolean tom_is_fun_sym_ChoiceId( tom.library.sl.Strategy  t) {return ( t instanceof tom.library.sl.ChoiceId );}private static  tom.library.sl.Strategy  tom_empty_list_ChoiceId() { return  null ;}private static  tom.library.sl.Strategy  tom_cons_list_ChoiceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { return  tom.library.sl.ChoiceId.make(head,tail) ;}private static  tom.library.sl.Strategy  tom_get_head_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.FIRST) );}private static  tom.library.sl.Strategy  tom_get_tail_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.THEN) );}private static boolean tom_is_empty_ChoiceId_Strategy( tom.library.sl.Strategy  t) {return ( t ==null );}   private static   tom.library.sl.Strategy  tom_append_list_ChoiceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {     if(( l1 ==null )) {       return l2;     } else if(( l2 ==null )) {       return l1;     } else if(( l1 instanceof tom.library.sl.ChoiceId )) {       if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ) ==null )) {         return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),l2) ;       } else {         return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),tom_append_list_ChoiceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ),l2)) ;       }     } else {       return  tom.library.sl.ChoiceId.make(l1,l2) ;     }   }   private static   tom.library.sl.Strategy  tom_get_slice_ChoiceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {     if( (begin.equals(end)) ) {       return tail;     } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_ChoiceId())) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  tom.library.sl.ChoiceId.make(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_ChoiceId(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.THEN) ):tom_empty_list_ChoiceId()),end,tail)) ;   }   private static  tom.library.sl.Strategy  tom_make_OneId( tom.library.sl.Strategy  v) { return ( new tom.library.sl.OneId(v) );}   private static  tom.library.sl.Strategy  tom_make_AllSeq( tom.library.sl.Strategy  s) { return ( new tom.library.sl.AllSeq(s) );}private static  tom.library.sl.Strategy  tom_make_AUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { return ( tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_cons_list_Sequence(tom_make_One(tom_make_Identity()),tom_empty_list_Sequence())),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_EUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { return ( tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_One(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_empty_list_Choice()))));} private static  tom.library.sl.Strategy  tom_make_Try( tom.library.sl.Strategy  s) { return ( tom_cons_list_Choice(s,tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice())) );}private static  tom.library.sl.Strategy  tom_make_Repeat( tom.library.sl.Strategy  s) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(tom_cons_list_Sequence(s,tom_cons_list_Sequence(tom_make_MuVar("_x"),tom_empty_list_Sequence())),tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_TopDown( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Sequence(v,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("_x")),tom_empty_list_Sequence()))) );}private static  tom.library.sl.Strategy  tom_make_OnceTopDown( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(v,tom_cons_list_Choice(tom_make_One(tom_make_MuVar("_x")),tom_empty_list_Choice()))) );}private static  tom.library.sl.Strategy  tom_make_RepeatId( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_SequenceId(v,tom_cons_list_SequenceId(tom_make_MuVar("_x"),tom_empty_list_SequenceId()))) );}private static  tom.library.sl.Strategy  tom_make_OnceTopDownId( tom.library.sl.Strategy  v) { return ( tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_ChoiceId(v,tom_cons_list_ChoiceId(tom_make_OneId(tom_make_MuVar("_x")),tom_empty_list_ChoiceId()))) );}      static class MapEntry {   private Object key;   private Object val;   public Object getKey() { return key; }   public Object getVal() { return val; }   public MapEntry(Object key, Object val) {     this.key = key;     this.val = val;   } }  private static boolean tom_equal_term_MapEntry(Object e1, Object e2) {return  e1.equals(e2) ;}private static boolean tom_is_sort_MapEntry(Object t) {return  t instanceof MapEntry ;}private static boolean tom_equal_term_Object(Object o1, Object o2) {return  o1.equals(o2) ;}private static boolean tom_is_sort_Object(Object t) {return  t instanceof Object ;}  private static boolean tom_equal_term_HashMap(Object l1, Object l2) {return  l1.equals(l2) ;}private static boolean tom_is_sort_HashMap(Object t) {return  t instanceof java.util.HashMap ;}   @SuppressWarnings("unchecked") private static java.util.HashMap hashMapAppend(MapEntry e, java.util.HashMap m) {   java.util.HashMap res = (java.util.HashMap) m.clone();   res.put(e.getKey(), e.getVal());   return res; }  @SuppressWarnings("unchecked") private static MapEntry hashMapGetHead(java.util.HashMap m) {   java.util.Set es = m.entrySet();   java.util.Iterator it = es.iterator();   java.util.Map.Entry e = (java.util.Map.Entry) it.next();   return new MapEntry(e.getKey(), e.getValue()); }  @SuppressWarnings("unchecked") private static java.util.HashMap hashMapGetTail(java.util.HashMap m) {   java.util.HashMap res = (java.util.HashMap) m.clone();   java.util.Set es = m.entrySet();   java.util.Iterator it = es.iterator();   java.util.Map.Entry e = (java.util.Map.Entry) it.next();   res.remove(e.getKey());   return res; }   private static boolean tom_equal_term_Collection(Object l1, Object l2) {return  l1.equals(l2) ;}private static boolean tom_is_sort_Collection(Object t) {return  t instanceof java.util.Collection ;} private static boolean tom_equal_term_Stackk(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Stackk(Object t) {return  (t instanceof maqv.msp.types.Stackk) ;}private static boolean tom_equal_term_Termo(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Termo(Object t) {return  (t instanceof maqv.msp.types.Termo) ;}private static boolean tom_equal_term_DefTipo(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_DefTipo(Object t) {return  (t instanceof maqv.msp.types.DefTipo) ;}private static boolean tom_equal_term_Boool(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Boool(Object t) {return  (t instanceof maqv.msp.types.Boool) ;}private static boolean tom_equal_term_Instrucao(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Instrucao(Object t) {return  (t instanceof maqv.msp.types.Instrucao) ;}private static boolean tom_equal_term_Instrucoes(Object t1, Object t2) {return  (t1==t2) ;}private static boolean tom_is_sort_Instrucoes(Object t) {return  (t instanceof maqv.msp.types.Instrucoes) ;}private static boolean tom_is_fun_sym_I( maqv.msp.types.Termo  t) {return  (t instanceof maqv.msp.types.termo.I) ;}private static  maqv.msp.types.Termo  tom_make_I( int  t0) { return  maqv.msp.types.termo.I.make(t0) ;}private static  int  tom_get_slot_I_i( maqv.msp.types.Termo  t) {return  t.geti() ;}private static boolean tom_is_fun_sym_S( maqv.msp.types.Termo  t) {return  (t instanceof maqv.msp.types.termo.S) ;}private static  maqv.msp.types.Termo  tom_make_S( String  t0) { return  maqv.msp.types.termo.S.make(t0) ;}private static  String  tom_get_slot_S_id( maqv.msp.types.Termo  t) {return  t.getid() ;}private static boolean tom_is_fun_sym_B( maqv.msp.types.Termo  t) {return  (t instanceof maqv.msp.types.termo.B) ;}private static  maqv.msp.types.Termo  tom_make_B( maqv.msp.types.Boool  t0) { return  maqv.msp.types.termo.B.make(t0) ;}private static  maqv.msp.types.Boool  tom_get_slot_B_b( maqv.msp.types.Termo  t) {return  t.getb() ;}private static boolean tom_is_fun_sym_F( maqv.msp.types.Termo  t) {return  (t instanceof maqv.msp.types.termo.F) ;}private static  int  tom_get_slot_F_f( maqv.msp.types.Termo  t) {return  t.getf() ;}private static  maqv.msp.types.Termo  tom_make_Vazio() { return  maqv.msp.types.termo.Vazio.make() ;}private static boolean tom_is_fun_sym_DInt( maqv.msp.types.DefTipo  t) {return  (t instanceof maqv.msp.types.deftipo.DInt) ;}private static boolean tom_is_fun_sym_DChar( maqv.msp.types.DefTipo  t) {return  (t instanceof maqv.msp.types.deftipo.DChar) ;}private static boolean tom_is_fun_sym_DBoolean( maqv.msp.types.DefTipo  t) {return  (t instanceof maqv.msp.types.deftipo.DBoolean) ;}private static boolean tom_is_fun_sym_DFloat( maqv.msp.types.DefTipo  t) {return  (t instanceof maqv.msp.types.deftipo.DFloat) ;}private static boolean tom_is_fun_sym_True( maqv.msp.types.Boool  t) {return  (t instanceof maqv.msp.types.boool.True) ;}private static  maqv.msp.types.Boool  tom_make_True() { return  maqv.msp.types.boool.True.make() ;}private static boolean tom_is_fun_sym_False( maqv.msp.types.Boool  t) {return  (t instanceof maqv.msp.types.boool.False) ;}private static  maqv.msp.types.Boool  tom_make_False() { return  maqv.msp.types.boool.False.make() ;}private static boolean tom_is_fun_sym_ALabel( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.ALabel) ;}private static  String  tom_get_slot_ALabel_id( maqv.msp.types.Instrucao  t) {return  t.getid() ;}private static boolean tom_is_fun_sym_Call( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Call) ;}private static  String  tom_get_slot_Call_id( maqv.msp.types.Instrucao  t) {return  t.getid() ;}private static boolean tom_is_fun_sym_Ret( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Ret) ;}private static boolean tom_is_fun_sym_Add( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Add) ;}private static boolean tom_is_fun_sym_Sub( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Sub) ;}private static boolean tom_is_fun_sym_Div( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Div) ;}private static boolean tom_is_fun_sym_Mul( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Mul) ;}private static boolean tom_is_fun_sym_Mod( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Mod) ;}private static boolean tom_is_fun_sym_Inc( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Inc) ;}private static boolean tom_is_fun_sym_Dec( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Dec) ;}private static boolean tom_is_fun_sym_Eq( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Eq) ;}private static boolean tom_is_fun_sym_Neq( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Neq) ;}private static boolean tom_is_fun_sym_Gt( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Gt) ;}private static boolean tom_is_fun_sym_GoEq( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.GoEq) ;}private static boolean tom_is_fun_sym_Lt( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Lt) ;}private static boolean tom_is_fun_sym_LoEq( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.LoEq) ;}private static boolean tom_is_fun_sym_Nott( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Nott) ;}private static boolean tom_is_fun_sym_Or( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Or) ;}private static boolean tom_is_fun_sym_And( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.And) ;}private static boolean tom_is_fun_sym_Halt( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Halt) ;}private static boolean tom_is_fun_sym_IIn( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.IIn) ;}private static  maqv.msp.types.DefTipo  tom_get_slot_IIn_tipo( maqv.msp.types.Instrucao  t) {return  t.gettipo() ;}private static boolean tom_is_fun_sym_IOut( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.IOut) ;}private static boolean tom_is_fun_sym_Jump( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Jump) ;}private static  String  tom_get_slot_Jump_id( maqv.msp.types.Instrucao  t) {return  t.getid() ;}private static boolean tom_is_fun_sym_Jumpf( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Jumpf) ;}private static  String  tom_get_slot_Jumpf_id( maqv.msp.types.Instrucao  t) {return  t.getid() ;}private static boolean tom_is_fun_sym_Push( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Push) ;}private static  maqv.msp.types.Termo  tom_get_slot_Push_t( maqv.msp.types.Instrucao  t) {return  t.gett() ;}private static boolean tom_is_fun_sym_Pusha( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Pusha) ;}private static  maqv.msp.types.Termo  tom_get_slot_Pusha_t( maqv.msp.types.Instrucao  t) {return  t.gett() ;}private static boolean tom_is_fun_sym_Load( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Load) ;}private static boolean tom_is_fun_sym_Store( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Store) ;}private static boolean tom_is_fun_sym_Decl( maqv.msp.types.Instrucao  t) {return  (t instanceof maqv.msp.types.instrucao.Decl) ;}private static  String  tom_get_slot_Decl_id( maqv.msp.types.Instrucao  t) {return  t.getid() ;}private static  int  tom_get_slot_Decl_initMemAddress( maqv.msp.types.Instrucao  t) {return  t.getinitMemAddress() ;}private static  int  tom_get_slot_Decl_size( maqv.msp.types.Instrucao  t) {return  t.getsize() ;}private static boolean tom_is_fun_sym_Stackk( maqv.msp.types.Stackk  t) {return  ((t instanceof maqv.msp.types.stackk.ConsStackk) || (t instanceof maqv.msp.types.stackk.EmptyStackk)) ;}private static  maqv.msp.types.Stackk  tom_empty_list_Stackk() { return  maqv.msp.types.stackk.EmptyStackk.make() ;}private static  maqv.msp.types.Stackk  tom_cons_list_Stackk( maqv.msp.types.Termo  e,  maqv.msp.types.Stackk  l) { return  maqv.msp.types.stackk.ConsStackk.make(e,l) ;}private static  maqv.msp.types.Termo  tom_get_head_Stackk_Stackk( maqv.msp.types.Stackk  l) {return  l.getHeadStackk() ;}private static  maqv.msp.types.Stackk  tom_get_tail_Stackk_Stackk( maqv.msp.types.Stackk  l) {return  l.getTailStackk() ;}private static boolean tom_is_empty_Stackk_Stackk( maqv.msp.types.Stackk  l) {return  l.isEmptyStackk() ;}   private static   maqv.msp.types.Stackk  tom_append_list_Stackk( maqv.msp.types.Stackk l1,  maqv.msp.types.Stackk  l2) {     if( l1.isEmptyStackk() ) {       return l2;     } else if( l2.isEmptyStackk() ) {       return l1;     } else if(  l1.getTailStackk() .isEmptyStackk() ) {       return  maqv.msp.types.stackk.ConsStackk.make( l1.getHeadStackk() ,l2) ;     } else {       return  maqv.msp.types.stackk.ConsStackk.make( l1.getHeadStackk() ,tom_append_list_Stackk( l1.getTailStackk() ,l2)) ;     }   }   private static   maqv.msp.types.Stackk  tom_get_slice_Stackk( maqv.msp.types.Stackk  begin,  maqv.msp.types.Stackk  end, maqv.msp.types.Stackk  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptyStackk()  ||  (end==tom_empty_list_Stackk()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  maqv.msp.types.stackk.ConsStackk.make( begin.getHeadStackk() ,( maqv.msp.types.Stackk )tom_get_slice_Stackk( begin.getTailStackk() ,end,tail)) ;   }   private static boolean tom_is_fun_sym_Instrucoes( maqv.msp.types.Instrucoes  t) {return  ((t instanceof maqv.msp.types.instrucoes.ConsInstrucoes) || (t instanceof maqv.msp.types.instrucoes.EmptyInstrucoes)) ;}private static  maqv.msp.types.Instrucoes  tom_empty_list_Instrucoes() { return  maqv.msp.types.instrucoes.EmptyInstrucoes.make() ;}private static  maqv.msp.types.Instrucoes  tom_cons_list_Instrucoes( maqv.msp.types.Instrucao  e,  maqv.msp.types.Instrucoes  l) { return  maqv.msp.types.instrucoes.ConsInstrucoes.make(e,l) ;}private static  maqv.msp.types.Instrucao  tom_get_head_Instrucoes_Instrucoes( maqv.msp.types.Instrucoes  l) {return  l.getHeadInstrucoes() ;}private static  maqv.msp.types.Instrucoes  tom_get_tail_Instrucoes_Instrucoes( maqv.msp.types.Instrucoes  l) {return  l.getTailInstrucoes() ;}private static boolean tom_is_empty_Instrucoes_Instrucoes( maqv.msp.types.Instrucoes  l) {return  l.isEmptyInstrucoes() ;}   private static   maqv.msp.types.Instrucoes  tom_append_list_Instrucoes( maqv.msp.types.Instrucoes l1,  maqv.msp.types.Instrucoes  l2) {     if( l1.isEmptyInstrucoes() ) {       return l2;     } else if( l2.isEmptyInstrucoes() ) {       return l1;     } else if(  l1.getTailInstrucoes() .isEmptyInstrucoes() ) {       return  maqv.msp.types.instrucoes.ConsInstrucoes.make( l1.getHeadInstrucoes() ,l2) ;     } else {       return  maqv.msp.types.instrucoes.ConsInstrucoes.make( l1.getHeadInstrucoes() ,tom_append_list_Instrucoes( l1.getTailInstrucoes() ,l2)) ;     }   }   private static   maqv.msp.types.Instrucoes  tom_get_slice_Instrucoes( maqv.msp.types.Instrucoes  begin,  maqv.msp.types.Instrucoes  end, maqv.msp.types.Instrucoes  tail) {     if( (begin==end) ) {       return tail;     } else if( (end==tail)  && ( end.isEmptyInstrucoes()  ||  (end==tom_empty_list_Instrucoes()) )) {       /* code to avoid a call to make, and thus to avoid looping during list-matching */       return begin;     }     return  maqv.msp.types.instrucoes.ConsInstrucoes.make( begin.getHeadInstrucoes() ,( maqv.msp.types.Instrucoes )tom_get_slice_Instrucoes( begin.getTailInstrucoes() ,end,tail)) ;   }    




	private Instrucoes programa;
	private Instrucoes original;
	private Stackk stack;
	private Stackk stackFuncs;
	private String actualFuncName;
	private Map<String,Integer> symbols;
	private ArrayList<Termo> heap;
	private int pc;
	private int numProg;
	private StringBuilder output;

	public static void main(String[] args) {
		try {
			mspLexer lexer = new mspLexer(new ANTLRInputStream(new FileInputStream(args[0])));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			mspParser parser = new mspParser(tokens);
			// Parse the input expression
			Tree b = (Tree) parser.programa().getTree();
			//System.out.println("Result = " + mspAdaptor.getTerm(b)); // name of the Gom module + Adaptor
			Instrucoes p = (Instrucoes) mspAdaptor.getTerm(b);
			Instrucoes original = (Instrucoes) mspAdaptor.getTerm(b);

			Main main = new Main(p, original);

			main.run(p);

			/* Export this representation to .dot file*/
			/*
			try{
				FileWriter out=new FileWriter("gram.dot");
				Viewer.toDot(p,out);
			}
			catch (IOException e){
				System.out.println("ERROR in dot file"); 
			}
			*/
			if (args.length > 1) {
				try {
					PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(args[1], true)));
        			pw.print(main.getOutput());
        			pw.flush(); pw.close();
				}
				catch (IOException e){
					System.err.println("exception: " + e);
					return;
		    	} 
			}
			else {
				System.out.println(main.getOutput());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Main(Instrucoes insts, Instrucoes orig) {
		programa = insts;
		original = orig;
		actualFuncName = "";
		stack = tom_empty_list_Stackk();
		stackFuncs = tom_empty_list_Stackk();
		heap = new ArrayList<Termo>();
		symbols = new HashMap<String, Integer>();
		pc = 0;
		numProg = 0;
		output = new StringBuilder();
	}
	
	public String getOutput(){
		return output.toString();
	}

	private Instrucoes getNInstr(Instrucoes prog, int progc){
		{{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) {
 
				if (progc == 0) {
					return (( maqv.msp.types.Instrucoes )prog);
				}
				else { return getNInstr(tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)),progc-1); }
			}}}}}

		return tom_empty_list_Instrucoes();
	}

	private Instrucoes getCalledFunction(Instrucoes prog, String called){
		{{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) { maqv.msp.types.Instrucao  tomMatch2_5=tom_get_head_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog));if (tom_is_sort_Instrucao(tomMatch2_5)) {if (tom_is_fun_sym_Call((( maqv.msp.types.Instrucao )tomMatch2_5))) { maqv.msp.types.Instrucoes  tom_insts=tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog));

				if(called.equals(tom_get_slot_Call_id(tomMatch2_5))){
					return tom_insts;
				}else{
					return getCalledFunction(tom_insts,called);
				}
			}}}}}}{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) {
 return getCalledFunction(tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)),called); }}}}}

		return tom_empty_list_Instrucoes();
	}

	private Instrucoes getNInstr(Instrucoes prog, String callerF, String called){
		{{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) { maqv.msp.types.Instrucao  tomMatch3_5=tom_get_head_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog));if (tom_is_sort_Instrucao(tomMatch3_5)) {if (tom_is_fun_sym_ALabel((( maqv.msp.types.Instrucao )tomMatch3_5))) { maqv.msp.types.Instrucoes  tom_insts=tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog));

				if(callerF.equals(tom_get_slot_ALabel_id(tomMatch3_5))){
					return getCalledFunction(tom_insts, called);
				}else{
					return getNInstr(tom_insts,callerF,called);
				}
			}}}}}}{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) {
 return getNInstr(tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)),callerF,called); }}}}}

		return tom_empty_list_Instrucoes();
	}

	private Instrucoes jmp(Instrucoes prog, String label){
		{{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) { maqv.msp.types.Instrucao  tomMatch4_5=tom_get_head_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog));if (tom_is_sort_Instrucao(tomMatch4_5)) {if (tom_is_fun_sym_ALabel((( maqv.msp.types.Instrucao )tomMatch4_5))) { String  tom_l=tom_get_slot_ALabel_id(tomMatch4_5); maqv.msp.types.Instrucoes  tom_insts=tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog));

				if (label.equals(tom_l)) {
					if(tom_l.startsWith("f:")){
						actualFuncName = tom_l;
					}
					return tom_insts; 
				}else{
					return jmp(tom_insts,label);
				}
			}}}}}}{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) {
 return jmp(tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)),label); }}}}}

		return tom_empty_list_Instrucoes();
	}

	private void pushFuncs(Termo termo){
		{{if (tom_is_sort_Stackk(stackFuncs)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stackFuncs)))) {

				this.stackFuncs = tom_cons_list_Stackk(termo,tom_append_list_Stackk((( maqv.msp.types.Stackk )stackFuncs),tom_empty_list_Stackk()));
			}}}}

	}

	private void pushStack(Termo termo){
		{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {
 this.stack = tom_cons_list_Stackk(termo,tom_append_list_Stackk((( maqv.msp.types.Stackk )stack),tom_empty_list_Stackk())); }}}}

	}

	private void popFuncs(){
		{{if (tom_is_sort_Stackk(stackFuncs)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stackFuncs)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stackFuncs)))) {

				this.stackFuncs = tom_append_list_Stackk(tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stackFuncs)),tom_empty_list_Stackk());
			}}}}}

	}

	private void popStack(){
		{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) {
 this.stack = tom_append_list_Stackk(tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack)),tom_empty_list_Stackk()); }}}}}

	}

	private Termo topFuncs(){
		{{if (tom_is_sort_Stackk(stackFuncs)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stackFuncs)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stackFuncs)))) {
 return tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stackFuncs)); }}}}}

		return tom_make_Vazio();
	}

	private Termo topStack() {
		{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) {
 return tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack)); }}}}}

		return tom_make_Vazio();
	}

	private void memAlloc(String symbol, int initMemAddress, int size) {
		Integer memAddress = symbols.get(symbol);
		if (memAddress == null) {
			symbols.put(symbol, initMemAddress);
			for (int i = 0; i < size; i++){
				heap.add(initMemAddress + i,tom_make_Vazio());
			}
		}
	}

	private int getMemAddress(String symbol) {
		return symbols.get(symbol);
	}

	private Termo getMem(int memAddress) {
		return heap.get(memAddress);
	}

	private void putMem(int memAddress, Termo value) {
		heap.set(memAddress,value);
	}

	public String run(Instrucoes prog) {
		pc++;
		Instrucoes orig = this.original;
		{{if (tom_is_sort_Instrucoes(prog)) {if (tom_is_fun_sym_Instrucoes((( maqv.msp.types.Instrucoes )(( maqv.msp.types.Instrucoes )prog)))) {if (!(tom_is_empty_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)))) { maqv.msp.types.Instrucao  tom_inst=tom_get_head_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog)); maqv.msp.types.Instrucoes  tom_instrs=tom_get_tail_Instrucoes_Instrucoes((( maqv.msp.types.Instrucoes )prog));{{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_ALabel((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) { String  tom_id=tom_get_slot_ALabel_id((( maqv.msp.types.Instrucao )tom_inst));



						if(tom_id.startsWith("f:")){
							actualFuncName=tom_id;
						}
						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Call((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) { String  tom_id=tom_get_slot_Call_id((( maqv.msp.types.Instrucao )tom_inst));pushFuncs(tom_make_S(actualFuncName))

;
						pushFuncs(tom_make_S(tom_id));
						prog = jmp(orig,tom_id);
						return run(prog);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Ret((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo calledLabel = topFuncs(); 
						popFuncs();
						Termo callerFLabel = topFuncs();
						popFuncs();
						String called = "", callerF = "";
						{{if (tom_is_sort_Termo(calledLabel)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )calledLabel))) {if (tom_is_fun_sym_S((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )calledLabel)))) {

								called = tom_get_slot_S_id((( maqv.msp.types.Termo )calledLabel));
							}}}}{if (tom_is_sort_Termo(calledLabel)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )calledLabel))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )calledLabel)))) { int  tom_valor=tom_get_slot_I_i((( maqv.msp.types.Termo )calledLabel));
 
								pc = tom_valor;
								prog = getNInstr(orig,tom_valor);
							}}}}}{{if (tom_is_sort_Termo(callerFLabel)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )callerFLabel))) {if (tom_is_fun_sym_S((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )callerFLabel)))) { String  tom_id=tom_get_slot_S_id((( maqv.msp.types.Termo )callerFLabel));


								actualFuncName = tom_id;
								callerF = tom_id;
							}}}}}

						prog = getNInstr(orig,callerF,called);
						return run(prog);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Add((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch15_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch15_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch15_6))) { maqv.msp.types.Stackk  tomMatch15_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch15_2))) { maqv.msp.types.Termo  tomMatch15_9=tom_get_head_Stackk_Stackk(tomMatch15_2);if (tom_is_sort_Termo(tomMatch15_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch15_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch15_2);
								int resultado = tom_get_slot_I_i(tomMatch15_9)+tom_get_slot_I_i(tomMatch15_6);
								pushStack(tom_make_I(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Sub((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch16_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch16_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch16_6))) { maqv.msp.types.Stackk  tomMatch16_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch16_2))) { maqv.msp.types.Termo  tomMatch16_9=tom_get_head_Stackk_Stackk(tomMatch16_2);if (tom_is_sort_Termo(tomMatch16_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch16_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch16_2);
								int resultado = tom_get_slot_I_i(tomMatch16_9)- tom_get_slot_I_i(tomMatch16_6);
								pushStack(tom_make_I(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Div((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch17_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch17_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch17_6))) { maqv.msp.types.Stackk  tomMatch17_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch17_2))) { maqv.msp.types.Termo  tomMatch17_9=tom_get_head_Stackk_Stackk(tomMatch17_2);if (tom_is_sort_Termo(tomMatch17_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch17_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch17_2);
								int resultado = tom_get_slot_I_i(tomMatch17_9)/ tom_get_slot_I_i(tomMatch17_6);
								pushStack(tom_make_I(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Mul((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch18_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch18_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch18_6))) { maqv.msp.types.Stackk  tomMatch18_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch18_2))) { maqv.msp.types.Termo  tomMatch18_9=tom_get_head_Stackk_Stackk(tomMatch18_2);if (tom_is_sort_Termo(tomMatch18_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch18_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch18_2);
								int resultado = tom_get_slot_I_i(tomMatch18_9)* tom_get_slot_I_i(tomMatch18_6);
								pushStack(tom_make_I(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Mod((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch19_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch19_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch19_6))) { maqv.msp.types.Stackk  tomMatch19_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch19_2))) { maqv.msp.types.Termo  tomMatch19_9=tom_get_head_Stackk_Stackk(tomMatch19_2);if (tom_is_sort_Termo(tomMatch19_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch19_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch19_2);
								int resultado = tom_get_slot_I_i(tomMatch19_9)% tom_get_slot_I_i(tomMatch19_6);
								pushStack(tom_make_I(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Inc((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo t = topStack();
						popStack();
						{{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { int  tom_memAddress=tom_get_slot_I_i((( maqv.msp.types.Termo )t));
 
								Termo t2 = getMem(tom_memAddress);
								int valorToInc = 0;
								{{if (tom_is_sort_Termo(t2)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t2))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t2)))) {
 valorToInc = tom_get_slot_I_i((( maqv.msp.types.Termo )t2))+1; }}}}}

								putMem(tom_memAddress,tom_make_I(valorToInc));
								
								return run(tom_instrs);
							}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Dec((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo t = topStack();
						popStack();
						{{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { int  tom_memAddress=tom_get_slot_I_i((( maqv.msp.types.Termo )t));
 
								Termo t2 = getMem(tom_memAddress);
								int valorToDec = 0;
								{{if (tom_is_sort_Termo(t2)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t2))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t2)))) {
 valorToDec = tom_get_slot_I_i((( maqv.msp.types.Termo )t2))-1; }}}}}

								putMem(tom_memAddress,tom_make_I(valorToDec));
								
								return run(tom_instrs);
							}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Eq((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch24_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch24_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch24_6))) { maqv.msp.types.Stackk  tomMatch24_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch24_2))) { maqv.msp.types.Termo  tomMatch24_9=tom_get_head_Stackk_Stackk(tomMatch24_2);if (tom_is_sort_Termo(tomMatch24_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch24_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch24_2);
								Boool resultado = (tom_get_slot_I_i(tomMatch24_9)== tom_get_slot_I_i(tomMatch24_6)) ? tom_make_True() : tom_make_False();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Neq((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch25_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch25_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch25_6))) { maqv.msp.types.Stackk  tomMatch25_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch25_2))) { maqv.msp.types.Termo  tomMatch25_9=tom_get_head_Stackk_Stackk(tomMatch25_2);if (tom_is_sort_Termo(tomMatch25_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch25_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch25_2);
								Boool resultado = (tom_get_slot_I_i(tomMatch25_9)== tom_get_slot_I_i(tomMatch25_6)) ? tom_make_False() : tom_make_True();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Gt((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch26_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch26_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch26_6))) { maqv.msp.types.Stackk  tomMatch26_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch26_2))) { maqv.msp.types.Termo  tomMatch26_9=tom_get_head_Stackk_Stackk(tomMatch26_2);if (tom_is_sort_Termo(tomMatch26_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch26_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch26_2);
								Boool resultado = (tom_get_slot_I_i(tomMatch26_9)> tom_get_slot_I_i(tomMatch26_6)) ? tom_make_True() : tom_make_False();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_GoEq((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch27_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch27_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch27_6))) { maqv.msp.types.Stackk  tomMatch27_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch27_2))) { maqv.msp.types.Termo  tomMatch27_9=tom_get_head_Stackk_Stackk(tomMatch27_2);if (tom_is_sort_Termo(tomMatch27_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch27_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch27_2);
								Boool resultado = (tom_get_slot_I_i(tomMatch27_9)>= tom_get_slot_I_i(tomMatch27_6)) ? tom_make_True() : tom_make_False();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Lt((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch28_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch28_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch28_6))) { maqv.msp.types.Stackk  tomMatch28_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch28_2))) { maqv.msp.types.Termo  tomMatch28_9=tom_get_head_Stackk_Stackk(tomMatch28_2);if (tom_is_sort_Termo(tomMatch28_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch28_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch28_2);
								Boool resultado = (tom_get_slot_I_i(tomMatch28_9)< tom_get_slot_I_i(tomMatch28_6)) ? tom_make_True() : tom_make_False();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_LoEq((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch29_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch29_6)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch29_6))) { maqv.msp.types.Stackk  tomMatch29_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch29_2))) { maqv.msp.types.Termo  tomMatch29_9=tom_get_head_Stackk_Stackk(tomMatch29_2);if (tom_is_sort_Termo(tomMatch29_9)) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )tomMatch29_9))) {


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch29_2);
								Boool resultado = (tom_get_slot_I_i(tomMatch29_9)<=tom_get_slot_I_i(tomMatch29_6)) ? tom_make_True() : tom_make_False();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Nott((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo t = topStack();
						popStack();
						{{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) {pushStack((( maqv.msp.types.Termo )t))
; }}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_S((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) {pushStack((( maqv.msp.types.Termo )t))
; }}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_F((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) {pushStack((( maqv.msp.types.Termo )t))
; }}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { maqv.msp.types.Boool  tomMatch30_13=tom_get_slot_B_b((( maqv.msp.types.Termo )t));if (tom_is_sort_Boool(tomMatch30_13)) {if (tom_is_fun_sym_True((( maqv.msp.types.Boool )tomMatch30_13))) {pushStack(tom_make_B(tom_make_False()))
; }}}}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { maqv.msp.types.Boool  tomMatch30_19=tom_get_slot_B_b((( maqv.msp.types.Termo )t));if (tom_is_sort_Boool(tomMatch30_19)) {if (tom_is_fun_sym_False((( maqv.msp.types.Boool )tomMatch30_19))) {pushStack(tom_make_B(tom_make_True()))
; }}}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Or((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch31_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch31_6)) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )tomMatch31_6))) { maqv.msp.types.Boool  tom_v2=tom_get_slot_B_b(tomMatch31_6); maqv.msp.types.Stackk  tomMatch31_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch31_2))) { maqv.msp.types.Termo  tomMatch31_9=tom_get_head_Stackk_Stackk(tomMatch31_2);if (tom_is_sort_Termo(tomMatch31_9)) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )tomMatch31_9))) { maqv.msp.types.Boool  tom_v1=tom_get_slot_B_b(tomMatch31_9);


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch31_2);
								boolean valor1 = true, valor2 = true;
								{{if (tom_is_sort_Boool(tom_v1)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v1))) {if (tom_is_fun_sym_True((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v1)))) {valor1
= true; }}}}{if (tom_is_sort_Boool(tom_v1)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v1))) {if (tom_is_fun_sym_False((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v1)))) {valor1
= false; }}}}}{{if (tom_is_sort_Boool(tom_v2)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v2))) {if (tom_is_fun_sym_True((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v2)))) {valor2


= true; }}}}{if (tom_is_sort_Boool(tom_v2)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v2))) {if (tom_is_fun_sym_False((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v2)))) {valor2
= false; }}}}}

								Boool resultado = (valor1 || valor2) ? tom_make_True() : tom_make_False();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_And((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {{{if (tom_is_sort_Stackk(stack)) {if (tom_is_fun_sym_Stackk((( maqv.msp.types.Stackk )(( maqv.msp.types.Stackk )stack)))) {if (!(tom_is_empty_Stackk_Stackk((( maqv.msp.types.Stackk )stack)))) { maqv.msp.types.Termo  tomMatch34_6=tom_get_head_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (tom_is_sort_Termo(tomMatch34_6)) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )tomMatch34_6))) { maqv.msp.types.Boool  tom_v2=tom_get_slot_B_b(tomMatch34_6); maqv.msp.types.Stackk  tomMatch34_2=tom_get_tail_Stackk_Stackk((( maqv.msp.types.Stackk )stack));if (!(tom_is_empty_Stackk_Stackk(tomMatch34_2))) { maqv.msp.types.Termo  tomMatch34_9=tom_get_head_Stackk_Stackk(tomMatch34_2);if (tom_is_sort_Termo(tomMatch34_9)) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )tomMatch34_9))) { maqv.msp.types.Boool  tom_v1=tom_get_slot_B_b(tomMatch34_9);


 
								stack = tom_get_tail_Stackk_Stackk(tomMatch34_2);
								boolean valor1 = true, valor2 = true;
								{{if (tom_is_sort_Boool(tom_v1)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v1))) {if (tom_is_fun_sym_True((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v1)))) {valor1
= true; }}}}{if (tom_is_sort_Boool(tom_v1)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v1))) {if (tom_is_fun_sym_False((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v1)))) {valor1
= false; }}}}}{{if (tom_is_sort_Boool(tom_v2)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v2))) {if (tom_is_fun_sym_True((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v2)))) {valor2


= true; }}}}{if (tom_is_sort_Boool(tom_v2)) {if (tom_is_sort_Boool((( maqv.msp.types.Boool )tom_v2))) {if (tom_is_fun_sym_False((( maqv.msp.types.Boool )(( maqv.msp.types.Boool )tom_v2)))) {valor2
= false; }}}}}

								Boool resultado = (valor1 && valor2) ? tom_make_True() : tom_make_False();
								pushStack(tom_make_B(resultado));
								return run(tom_instrs);
							}}}}}}}}}}

					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Halt((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {
 return ""; }}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_IIn((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) { maqv.msp.types.DefTipo  tom_tipo=tom_get_slot_IIn_tipo((( maqv.msp.types.Instrucao )tom_inst));

						BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						try{
							String iin = br.readLine();
							{{if (tom_is_sort_DefTipo(tom_tipo)) {if (tom_is_sort_DefTipo((( maqv.msp.types.DefTipo )tom_tipo))) {if (tom_is_fun_sym_DInt((( maqv.msp.types.DefTipo )(( maqv.msp.types.DefTipo )tom_tipo)))) {

									try{
										int v1 = Integer.parseInt(iin);
										pushStack(tom_make_I(v1));
									}catch(NumberFormatException nfe){
										System.err.println("Invalid Format!");
									}
								}}}}{if (tom_is_sort_DefTipo(tom_tipo)) {if (tom_is_sort_DefTipo((( maqv.msp.types.DefTipo )tom_tipo))) {if (tom_is_fun_sym_DChar((( maqv.msp.types.DefTipo )(( maqv.msp.types.DefTipo )tom_tipo)))) {

									String s = ""+iin.charAt(0);
									pushStack(tom_make_S(s));
								}}}}{if (tom_is_sort_DefTipo(tom_tipo)) {if (tom_is_sort_DefTipo((( maqv.msp.types.DefTipo )tom_tipo))) {if (tom_is_fun_sym_DBoolean((( maqv.msp.types.DefTipo )(( maqv.msp.types.DefTipo )tom_tipo)))) {

									if (iin.equalsIgnoreCase("true")) { pushStack(tom_make_B(tom_make_True())); }
									else if (iin.equalsIgnoreCase("false")) { pushStack(tom_make_B(tom_make_False())); }
									else { System.err.println("Invalid Format!"); }
								}}}}{if (tom_is_sort_DefTipo(tom_tipo)) {if (tom_is_sort_DefTipo((( maqv.msp.types.DefTipo )tom_tipo))) {if (tom_is_fun_sym_DFloat((( maqv.msp.types.DefTipo )(( maqv.msp.types.DefTipo )tom_tipo)))) {

									try{
										int v1 = Integer.parseInt(iin);
										pushStack(tom_make_I(v1));
									}catch(NumberFormatException nfe){
										System.err.println("Invalid Format!");
									}
								}}}}}

				       }
				       catch (IOException e){
				    	   System.err.println("exception: " + e);
				       } 
				       return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_IOut((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo t = topStack();
						popStack();
						{{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) {
 output.append(tom_get_slot_I_i((( maqv.msp.types.Termo )t))+"\n"); }}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_S((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) {
 output.append(tom_get_slot_S_id((( maqv.msp.types.Termo )t))+"\n"); }}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_F((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) {
 output.append(tom_get_slot_F_f((( maqv.msp.types.Termo )t))+"\n"); }}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { maqv.msp.types.Boool  tomMatch38_13=tom_get_slot_B_b((( maqv.msp.types.Termo )t));if (tom_is_sort_Boool(tomMatch38_13)) {if (tom_is_fun_sym_True((( maqv.msp.types.Boool )tomMatch38_13))) {
 output.append("True"+"\n"); }}}}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { maqv.msp.types.Boool  tomMatch38_19=tom_get_slot_B_b((( maqv.msp.types.Termo )t));if (tom_is_sort_Boool(tomMatch38_19)) {if (tom_is_fun_sym_False((( maqv.msp.types.Boool )tomMatch38_19))) {
 output.append("False"+"\n"); }}}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Jump((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						prog = jmp(orig,tom_get_slot_Jump_id((( maqv.msp.types.Instrucao )tom_inst)));
						return run(prog);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Jumpf((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo t = topStack();
						popStack();
						{{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { maqv.msp.types.Boool  tomMatch39_1=tom_get_slot_B_b((( maqv.msp.types.Termo )t));if (tom_is_sort_Boool(tomMatch39_1)) {if (tom_is_fun_sym_True((( maqv.msp.types.Boool )tomMatch39_1))) {
 return run(tom_instrs); }}}}}}{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_B((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) { maqv.msp.types.Boool  tomMatch39_7=tom_get_slot_B_b((( maqv.msp.types.Termo )t));if (tom_is_sort_Boool(tomMatch39_7)) {if (tom_is_fun_sym_False((( maqv.msp.types.Boool )tomMatch39_7))) {
 
								prog = jmp(orig,tom_get_slot_Jumpf_id((( maqv.msp.types.Instrucao )tom_inst)));
								return run(prog);
							}}}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Push((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {pushStack(tom_get_slot_Push_t((( maqv.msp.types.Instrucao )tom_inst)))

;
						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Pusha((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) { maqv.msp.types.Termo  tom_t=tom_get_slot_Pusha_t((( maqv.msp.types.Instrucao )tom_inst));{{if (tom_is_sort_Termo(tom_t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )tom_t))) {if (tom_is_fun_sym_S((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )tom_t)))) {


 
								int memAddress = getMemAddress(tom_get_slot_S_id((( maqv.msp.types.Termo )tom_t)));
								pushStack(tom_make_I(memAddress));
								
								return run(tom_instrs);
							}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Load((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo t = topStack();
						popStack();
						{{if (tom_is_sort_Termo(t)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t)))) {
 
								Termo t2 = getMem(tom_get_slot_I_i((( maqv.msp.types.Termo )t)));
								pushStack(t2);
								
								return run(tom_instrs);
							}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Store((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						Termo t = topStack();
						popStack();
						Termo t2 = topStack();
						popStack();
						{{if (tom_is_sort_Termo(t2)) {if (tom_is_sort_Termo((( maqv.msp.types.Termo )t2))) {if (tom_is_fun_sym_I((( maqv.msp.types.Termo )(( maqv.msp.types.Termo )t2)))) {
 
								putMem(tom_get_slot_I_i((( maqv.msp.types.Termo )t2)),t);
								
								return run(tom_instrs);
							}}}}}

						return run(tom_instrs);
					}}}}{if (tom_is_sort_Instrucao(tom_inst)) {if (tom_is_sort_Instrucao((( maqv.msp.types.Instrucao )tom_inst))) {if (tom_is_fun_sym_Decl((( maqv.msp.types.Instrucao )(( maqv.msp.types.Instrucao )tom_inst)))) {

						memAlloc(tom_get_slot_Decl_id((( maqv.msp.types.Instrucao )tom_inst)),tom_get_slot_Decl_initMemAddress((( maqv.msp.types.Instrucao )tom_inst)),tom_get_slot_Decl_size((( maqv.msp.types.Instrucao )tom_inst)));
						return run(tom_instrs);
					}}}}}

			}}}}}

		return "";
	}
}
