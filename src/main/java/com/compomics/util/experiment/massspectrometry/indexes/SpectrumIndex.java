package com.compomics.util.experiment.massspectrometry.indexes;

import com.compomics.util.experiment.massspectrometry.Peak;
import com.compomics.util.experiment.personalization.UrParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.apache.commons.math.util.FastMath;

/**
 * This map stores the fragment ions indexed by mass.
 *
 * @author Marc Vaudel
 */
public class SpectrumIndex implements UrParameter {

    /**
     * The precursor mass tolerance.
     */
    double precursorTolerance;
    /**
     * Boolean indicating whether the precursor mass tolerance is in ppm.
     */
    boolean ppm;
    /**
     * Map of the precursors by bin and m/z.
     */
    private HashMap<Integer, HashMap<Double, Peak>> peaksMap;
    /**
     * An m/z anchor to determine the bins in ppm
     */
    private static final double mzAnchor = 1000;
    /**
     * The log of the m/z anchor.
     */
    private static final double mzAnchorLog = FastMath.log(mzAnchor);
    /**
     * The scaling factor used for the bins in ppm.
     */
    private double scalingFactor;
    /**
     * The highest bin in index.
     */
    private Integer binMax;
    /**
     * The lowest bin in index.
     */
    private Integer binMin;
    /**
     * The total intensity above the intensity threshold.
     */
    private double totalIntensity;
    /**
     * The intensity limit used for the index.
     */
    public final double intensityLimit;

    /**
     * Constructor for an empty index.
     */
    public SpectrumIndex() {
        intensityLimit = 0.0;
    }

    /**
     * Builds a new index.
     *
     * @param peaks map of the peaks indexed by m/z
     * @param intenstiyLimit a lower limit for the intensity of the peaks to
     * index
     * @param tolerance the tolerance to use
     * @param ppm boolean indicating whether the tolerance is in ppm
     */
    public SpectrumIndex(HashMap<Double, Peak> peaks, double intenstiyLimit, double tolerance, boolean ppm) {
        this.intensityLimit = intenstiyLimit;
        this.peaksMap = new HashMap<Integer, HashMap<Double, Peak>>();
        this.precursorTolerance = tolerance;
        this.ppm = ppm;
        if (ppm) {
            scalingFactor = FastMath.log((1000000 - tolerance) / (1000000 + tolerance));
        }
        totalIntensity = 0.0;
        for (Peak peak : peaks.values()) {
            if (peak.intensity >= intenstiyLimit) {
                totalIntensity += peak.intensity;
                Integer bin = getBin(peak.mz);
                if (binMax == null || bin > binMax) {
                    binMax = bin;
                }
                if (binMin == null || bin < binMin) {
                    binMin = bin;
                }
                HashMap<Double, Peak> peaksInBin = peaksMap.get(bin);
                if (peaksInBin == null) {
                    peaksInBin = new HashMap<Double, Peak>(4);
                    peaksMap.put(bin, peaksInBin);
                }
                peaksInBin.put(peak.mz, peak);
            }
        }
    }

    /**
     * Returns the bin corresponding to the given m/z.
     *
     * @param mz the m/z
     *
     * @return the bin
     */
    public int getBin(double mz) {
        if (ppm) {
            return getBinPpm(mz);
        } else {
            return getBinAbsolute(mz);
        }
    }

    /**
     * Returns the bin corresponding to the given m/z with absolute tolerance in
     * Da.
     *
     * @param mz the m/z
     *
     * @return the bin
     */
    private int getBinAbsolute(double mz) {
        int bin = (int) (mz / precursorTolerance);
        return bin;
    }

    /**
     * Returns the bin corresponding to the given m/z with relative tolerance in
     * ppm.
     *
     * @param mz the m/z
     *
     * @return the bin
     */
    private int getBinPpm(double mz) {
        int bin = (int) ((FastMath.log(mz) - mzAnchorLog) / scalingFactor);
        return bin;
    }

    /**
     * Returns the peaks matching the given m/z. TODO: check only one/two bins
     * when possible.
     *
     * @param mz a m/z to query
     *
     * @return the peaks matching the given m/z
     */
    public ArrayList<Peak> getMatchingPeaks(double mz) {
        int bin0;
        if (ppm) {
            bin0 = getBinPpm(mz);
        } else {
            bin0 = getBinAbsolute(mz);
        }
        ArrayList<Peak> result = new ArrayList<Peak>(0);
        HashMap<Double, Peak> binContent = peaksMap.get(bin0 - 1);
        if (binContent != null) {
            for (Double peakMz : binContent.keySet()) {
                double error;
                if (ppm) {
                    error = 1000000 * (peakMz - mz) / mz;
                } else {
                    error = peakMz - mz;
                }
                if (Math.abs(error) <= precursorTolerance) {
                    result.add(binContent.get(peakMz));
                }
            }
        }
        binContent = peaksMap.get(bin0);
        if (binContent != null) {
            for (Double peakMz : binContent.keySet()) {
                double error;
                if (ppm) {
                    error = 1000000 * (peakMz - mz) / mz;
                } else {
                    error = peakMz - mz;
                }
                if (Math.abs(error) <= precursorTolerance) {
                    result.add(binContent.get(peakMz));
                }
            }
        }
        binContent = peaksMap.get(bin0 + 1);
        if (binContent != null) {
            for (Double peakMz : binContent.keySet()) {
                double error;
                if (ppm) {
                    error = 1000000 * (peakMz - mz) / mz;
                } else {
                    error = peakMz - mz;
                }
                if (Math.abs(error) <= precursorTolerance) {
                    result.add(binContent.get(peakMz));
                }
            }
        }
        return result;
    }

    /**
     * Returns the bins in the map as a list. The list is created every time me method is called.
     *
     * @return the bins in the map
     */
    public ArrayList<Integer> getBins() {
        return new ArrayList<Integer>(peaksMap.keySet());
    }

    /**
     * Returns the bins in the map as collection of keys from the map.
     *
     * @return the bins in the map
     */
    public Set<Integer> getRawBins() {
        return peaksMap.keySet();
    }

    /**
     * Returns the peaks at the given bin indexed by m/z. Null if none found.
     *
     * @param bin the bin number
     *
     * @return the peaks at the given bin
     */
    public HashMap<Double, Peak> getPeaksInBin(Integer bin) {
        return peaksMap.get(bin);
    }

    /**
     * Returns the mass associated with the given bin, the middle of the bin.
     *
     * @param bin the bin number
     *
     * @return the mass associated with the given bin
     */
    public Double getMass(int bin) {
        if (ppm) {
            return FastMath.exp((scalingFactor * bin) + mzAnchorLog);
        } else {
            return precursorTolerance * (0.5 + bin);
        }
    }

    /**
     * Returns the highest bin.
     * 
     * @return binMax the highest bin
     */
    public Integer getBinMax() {
        return binMax;
    }

    /**
     * Returns the lowest bin.
     * 
     * @return binMin the lowest bin
     */
    public Integer getBinMin() {
        return binMin;
    }

    /**
     * Returns the total intensity of the peaks above the intensity threshold.
     * 
     * @return the total intensity of the peaks above the intensity threshold
     */
    public double getTotalIntensity() {
        return totalIntensity;
    }

    @Override
    public String getParameterKey() {
        return "SpectrumIndex";
    }
}
