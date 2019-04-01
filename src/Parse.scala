import scala.util.matching.Regex

object Parse
{
  def parse(str: String): Option[Expr] =
  {
    val (e, s) = expr(str)
    if (s == "") e
    else None
  }

  private val number: Regex = """^\s*([+-]?[1-9][0-9]*)\s+(.*)""".r
  private val open: Regex = """^\s*\(\s*(.*)""".r
  private val close: Regex = """^\s*\)\s+(.*)""".r
  private val plus: Regex = """^\s*\+\s+(.*)""".r

  private def expr(str: String): (Option[Expr], String) = str match
  {
    case number(num, rest) => (Some(Expr.Num(num.toInt)), rest)
    case open(rest) => tail(rest)
    case _ => (None, str)
  }

  private def plusArgs(str: String): (Option[Expr], String) =
  {
    val (e, r) = expr(str)
    r match
    {
      case close(rest) => (None, rest)
      case _ => (None, r)
    }
  }

  private def tail(str: String): (Option[Expr], String) = str match
  {
    case plus(rest) => plusArgs(rest)
    case _ => (None, str)
  }
}
