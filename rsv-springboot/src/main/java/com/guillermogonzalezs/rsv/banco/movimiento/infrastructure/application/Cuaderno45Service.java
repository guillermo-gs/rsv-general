package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application;


import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.MovimientoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Cuaderno45Service {



    @Autowired
    MovimientoRepositoryImp mapper;

    private Integer tipoLineaActual = 0;
    private String conceptoActial ="";

    private List<Movimiento> movimientos;
    private Movimiento movimientoActual = new Movimiento();


    private String entidadActual;
    private String oficinaActual;
    private String cuentaActual;
    private Integer lineasGrabadas = 0;


    public List<Movimiento> procesarCuaderno(MultipartFile file) throws Exception {
        List<String> datos = this.leerFichero(file);
        return this.recorrerArray(datos);


    }


    public List<String> leerFichero(MultipartFile file) throws IOException {
        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {

            String linea;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((linea = br.readLine()) != null) {
                result.add(linea);
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }


    private List<Movimiento> recorrerArray(List<String> datos) throws Exception {
        this.movimientos = new ArrayList<Movimiento>();
        for (String linea : datos) {


            switch (linea.substring(0, 2)) {
                case "11":
                    this.linea11(linea);
                    break;
                case "22":
                    this.linea22(linea);
                    break;
                case "23":
                    this.linea23(linea);
                    break;
                case "33":
                    this.linea33(linea);
                    break;
                case "88":
                    this.linea88(linea);
                    break;

            }
        }

        return this.mapper.grabarLista(this.movimientos);


    }


    private void linea11(String linea) {
        this.entidadActual= linea.substring(2,6);
        this.oficinaActual = linea.substring(6,10);
        this.cuentaActual = linea.substring(10,20);
        String fechaInicial = linea.substring(20,26);
        String fechaFinal = linea.substring(26,32);
        String dedeHaber = linea.substring(32,33);
        String saldo = linea.substring(33,47);
        String ISO = linea.substring(47,50);
        String modalidad = linea.substring(50,51);
        String nombre = linea.substring(51,76);



    }

    private void linea22(String linea) throws Exception {

        SimpleDateFormat formato = new SimpleDateFormat("yyMMdd");

        this.movimientos.add( new Movimiento());


        String oficinaOrigen = linea.substring(6,10);
        String fechaOperacion = linea.substring(10,16);
        String fechaValor = linea.substring(16,22);
        String conceptoComun = linea.substring(22,24);
        String conceptoPropio = linea.substring(24,27);
        String debeHaber = linea.substring(27,28);
        String importe = linea.substring(28,42);
        String numeroDocumento = linea.substring(42,52);
        String referencia1 = linea.substring(52,64);
        String referencia2 = linea.substring(64,80);

        this.movimientos.get(this.movimientos.size() -1).setCuenta(this.entidadActual + this.oficinaActual + this.cuentaActual  );
        this.movimientos.get(this.movimientos.size() -1).setDetalle("");

        this.movimientos.get(this.movimientos.size() -1).setReferencia1(referencia1);
        this.movimientos.get(this.movimientos.size() -1).setReferencia2(referencia2);
        BigDecimal imp = new BigDecimal(importe);
        if (debeHaber.equals("1")) {
            imp = imp.multiply(BigDecimal.valueOf(-1));
            this.movimientos.get(this.movimientos.size() -1).setDebeHaber("D");
        } else {
            this.movimientos.get(this.movimientos.size() -1).setDebeHaber("H");
        }
        this.movimientos.get(this.movimientos.size() -1).setImporte(imp.divide(new BigDecimal(100)));
        this.movimientos.get(this.movimientos.size() -1).setFechaValor(formato.parse(fechaValor));
        this.movimientos.get(this.movimientos.size() -1).setFechaOperacion(formato.parse(fechaOperacion));


        System.out.println("Paso por linea 22");
        // movimientoActual.setFechaValor();

        ;
    }

    private void linea23(String linea) {

        String codigoDato = linea.substring(2,4);
        String concepto1 = (linea.substring(4,42).stripTrailing().equals("NOTPROVIDED"))?"":linea.substring(4,42);
        String concepto2 = (linea.substring(42,80).stripTrailing().equals("NOTPROVIDED"))?"":linea.substring(42,80);;
        String concepto = concepto1 + concepto2;
        String detalleAnterior = this.movimientos.get(this.movimientos.size() -1).getDetalle();
        this.movimientos.get(this.movimientos.size() -1).setDetalle(detalleAnterior + concepto );
        System.out.println("Paso por linea 23");
    }

    private void linea33(String linea) {
        System.out.println("Paso por linea 33");
        ;
    }

    private void linea88(String linea) {
       //
      //  this.repository.grabar(this.movimientos.get(2));
        ;
    }
}

