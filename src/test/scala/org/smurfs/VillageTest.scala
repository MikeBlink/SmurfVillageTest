package org.smurfs

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class VillageTest extends AnyWordSpecLike
                          with Matchers {
  "VillageGpsFix" should {
    "find a path when given random connections" in {

      val connections =
        List(
          SmurfHutConnection(SmurfHut("F"), SmurfHut("H")),
          SmurfHutConnection(SmurfHut("D"), SmurfHut("G")),
          SmurfHutConnection(SmurfHut("J"), SmurfHut("B")),
          SmurfHutConnection(SmurfHut("E"), SmurfHut("B")),
          SmurfHutConnection(SmurfHut("G"), SmurfHut("A")),
          SmurfHutConnection(SmurfHut("H"), SmurfHut("C")),
          SmurfHutConnection(SmurfHut("J"), SmurfHut("C")),
          SmurfHutConnection(SmurfHut("F"), SmurfHut("D")))

      val path = VillageGpsFix.fixPath(connections)
      val expectedPath = List(
        SmurfHut("A"),
        SmurfHut("G"),
        SmurfHut("D"),
        SmurfHut("F"),
        SmurfHut("H"),
        SmurfHut("C"),
        SmurfHut("J"),
        SmurfHut("B"),
        SmurfHut("E"))
      path shouldEqual oneOf(expectedPath, expectedPath.reverse)
    }
  }
}