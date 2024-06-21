package altice.lab

import altice.lab.service.LabSeqService
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.BadRequestException
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam

@Path("/labseq")
class LabSeqResource(val labSeqService: LabSeqService) {

    @GET
    @Path("/{n}")
    fun getLabseqValue(@PathParam("n") n: Int): Uni<Long> {
        if (n < 0) {
            return Uni.createFrom().emitter {
                it.fail(BadRequestException("n must be non-negative"))
            }
        }
        return labSeqService.getLabSeq(n)
    }
}