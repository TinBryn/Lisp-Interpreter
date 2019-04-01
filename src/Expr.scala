sealed trait Expr
{

  import Expr._

  def eval: Int = this match
  {
    case Sum(args) => args.map(_.eval).sum
    case Num(num) => num
  }
}

object Expr
{

  case class Sum(args: List[Expr]) extends Expr
  case class Num(num: Int) extends Expr

}

